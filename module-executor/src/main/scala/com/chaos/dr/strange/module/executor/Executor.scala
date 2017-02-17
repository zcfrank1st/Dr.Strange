package com.chaos.dr.strange.module.executor

import akka.actor.{Actor, ActorLogging}
import com.chaos.dr.strange.module.model.proto.Task
import com.chaos.dr.strange.module.persistence.Persistence
import org.apache.http.client.fluent.Request
import org.apache.http.entity.ContentType

import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Executor extends Actor with ActorLogging with Persistence {
  implicit val ec = context.dispatcher

  override def receive: Receive = {
    case task: Task.TaskProto =>
      val res = task.getReqUrl
      val ctnt = task.getReqContent

      task.getReqTyp.toLowerCase match {
        case "get" =>
          val req = Request.Get(res)
          manipulateRequest(req)(task)

        case "post" =>
          val req = Request.Post(res).bodyString(ctnt, ContentType.APPLICATION_JSON)
          manipulateRequest(req)(task)

        case "put" =>
          val req = Request.Put(res).bodyString(ctnt, ContentType.APPLICATION_JSON)
          manipulateRequest(req)(task)

        case "delete" =>
          val req =
            Request.Delete(res)
          manipulateRequest(req)(task)
      }

    case _ => log.error("[Executor] wrong message error")
  }

  def manipulateRequest(req: Request)(implicit task: Task.TaskProto): Unit = {
    try {
      req.connectTimeout(5).execute()
      val delFuture = Future {
        MysqlPersistence.clearSuccess(task.getPrimary)
      }
      delFuture onComplete {
        case Success(_) =>
        case Failure(t) =>
          log.error("[Executor] delFuture error occured: {}", t.getMessage)
      }
    } catch {
      case t: Throwable =>
        log.error("[Executor] manipulateRequest error occured: {}", t.getMessage)
        val setStatFuture = Future {
          MysqlPersistence.setFailed(task.getPrimary)
        }

        setStatFuture onComplete {
          case Success(_) =>
          case Failure(e) =>
            log.error("[Executor] setStatFuture error occured: {}", e.getMessage)
        }
    }
  }
}
