package com.chaos.dr.strange.api

import java.util.concurrent.TimeUnit

import akka.actor.{ActorPath, ActorSystem}
import akka.cluster.client.{ClusterClient, ClusterClientSettings}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.chaos.dr.strange.api.models.Task
import com.google.gson.Gson
//import com.chaos.dr.strange.meta.app
import com.typesafe.config.ConfigFactory

import scala.io.StdIn
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
/**
  * Created by zcfrank1st on 14/02/2017.
  */
//@app
object Main extends App with JsonSupport {
  val config = ConfigFactory.parseString("akka.cluster.roles = [client]").
    withFallback(ConfigFactory.load())
  implicit val system = ActorSystem("ClusterSystem", config)
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(3, TimeUnit.SECONDS)

  val initialContacts = Set(
    ActorPath.fromString(config.getString("api.contact-points"))) // todo refactor get connect point
  val c = system.actorOf(ClusterClient.props(
    ClusterClientSettings(system).withInitialContacts(initialContacts)), "client")

  val gson = new Gson

  object ApiPath {
    val route: Route =
      path("api") {
        post {
          entity(as[Task]) { task =>
            c ! ClusterClient.Send("/user/manager", gson.toJson(task), localAffinity = false)
            complete("ok")
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
