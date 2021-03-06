package com.chaos.dr.strange.api

import java.util.concurrent.TimeUnit

import akka.actor.{ActorPath, ActorSystem}
import akka.cluster.client.{ClusterClient, ClusterClientSettings}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.chaos.dr.strange.module.model.api.Task
import com.chaos.dr.strange.module.model.proto.Task.TaskProto
import com.chaos.dr.strange.module.persistence.Persistence
import com.chaos.dr.strange.module.register.Register

import scala.concurrent.Future
import scala.util.{Failure, Success}
//import com.chaos.dr.strange.meta.app
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
/**
  * Created by zcfrank1st on 14/02/2017.
  */
//@app
object Api extends App with JsonSupport with Register {
  val config = ConfigFactory.parseString("akka.cluster.roles = [client]").
    withFallback(ConfigFactory.load())
  implicit val system = ActorSystem("ClusterSystem", config)
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3, TimeUnit.SECONDS)

  val contactPointsTemplate = config.getString("api.contact-points")
  val initialContacts = RedisRegister.availableRegisters().map { conn =>
    ActorPath.fromString(contactPointsTemplate.replace("%[connection]", conn))
  }
  val c = system.actorOf(ClusterClient.props(
    ClusterClientSettings(system).withInitialContacts(initialContacts)), "client")

  object ApiPath extends Persistence {
    val route: Route =
      path("api") {
        post {
          entity(as[Task]) { task =>
            val persistFuture = Future {
              MysqlPersistence.keep(task)
            }

            onComplete(persistFuture) {
              case Success(key) =>
                val taskProto = TaskProto.newBuilder().setPrimary(key).setDelayTo(task.delayTo).setReqContent(task.reqContent).setReqTyp(task.reqTyp).setReqUrl(task.reqUrl).setTyp(task.typ).setIsIdem(task.isIdem).build()
                c ! ClusterClient.Send("/user/manager", taskProto , localAffinity = false)
                complete("ok")

              case Failure(_) => complete("error")
            }
          }
        }
      }
  }

  val httpPort = ConfigFactory.load().getInt("api.http.port")
  val bindingFuture = Http().bindAndHandle(ApiPath.route, "0.0.0.0", httpPort)
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
