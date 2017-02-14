package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import com.chaos.dr.strange.core.models.Task
import org.apache.http.client.fluent.{Request, Response}
import org.apache.http.entity.ContentType

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Executor extends Actor with ActorLogging {
  implicit val ec: ExecutionContext = context.dispatcher

  override def receive: Receive = {
    case task @ Task(_, _, typ, res, ctnt) =>
      typ.toLowerCase match {
        case "get" =>
          val future = Future {
            Request.Get(res).execute()
          }
          manipulateFailed(task, future)

        case "post" =>
          val future = Future {
            Request.Post(res).bodyString(ctnt, ContentType.APPLICATION_JSON).execute()
          }
          manipulateFailed(task, future)

        case "put" =>
          val future = Future {
            Request.Put(res).bodyString(ctnt, ContentType.APPLICATION_JSON).execute()
          }
          manipulateFailed(task, future)

        case "delete" =>
          val future = Future {
            Request.Delete(res).execute()
          }
          manipulateFailed(task, future)
      }

    case _ => // nothing
  }

  def manipulateFailed(task: Task, future: Future[Response]): Unit = {
    future onFailure {
      case _ =>
        val record = context.actorOf(Props[Record])
        record ! task
    }

    // TODO future on complete
  }
}
