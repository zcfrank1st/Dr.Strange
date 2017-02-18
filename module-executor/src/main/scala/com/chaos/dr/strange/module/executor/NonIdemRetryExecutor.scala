package com.chaos.dr.strange.module.executor

import akka.actor.{Actor, ActorLogging}
import com.chaos.dr.strange.module.model.db.Record
import com.chaos.dr.strange.module.model.proto.Task
import com.chaos.dr.strange.module.persistence.Persistence
import org.apache.http.client.fluent.{Request, Response}
import org.apache.http.entity.ContentType

import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by zcfrank1st on 17/02/2017.
  */
class NonIdemRetryExecutor extends Actor with Persistence with ActorLogging {
  import scala.concurrent.ExecutionContext.Implicits.global

  override def receive: Receive = {
    case "start" =>
      val nonIdemFails = MysqlPersistence.retrieveNonIdemFails()

      // 串行执行完
      val futureList = nonIdemFails map { record =>
        Future {
          httpSyncRequest(record)
        }
      }

      val fs: Future[List[Response]] = Future.sequence(futureList)

      for {
        resultList <- fs
      } yield resultList

      // once again
      self ! "start"

    case _ => log.warning("[NonIdemRetryExecutor] illegal command")
  }


  private[this] def httpSyncRequest (record: Record) : Response = {
    val task = record.task
    task.getReqTyp.toLowerCase match {
      case "get" =>
        val req = Request.Get(task.getReqUrl)
        manipulateSyncRequest(req)(task)

      case "post" =>
        val req = Request.Post(task.getReqUrl).bodyString(task.getReqContent, ContentType.APPLICATION_JSON)
        manipulateSyncRequest(req)(task)

      case "put" =>
        val req = Request.Put(task.getReqUrl).bodyString(task.getReqContent, ContentType.APPLICATION_JSON)
        manipulateSyncRequest(req)(task)

      case "delete" =>
        val req =
          Request.Delete(task.getReqUrl)
        manipulateSyncRequest(req)(task)
    }
  }

  private[this] def manipulateSyncRequest (req: Request)(implicit task: Task.TaskProto) : Response = {
    try {
      val resp = req.connectTimeout(5).execute()
      val delFuture = Future {
        MysqlPersistence.clearSuccess(task.getPrimary)
      }
      delFuture onComplete {
        case Success(_) =>
        case Failure(t) =>
          log.error("[NonIdemRetryExecutor] delFuture error occured: {}", t.getMessage)
      }
      resp

    } catch {
      case t: Throwable =>
        log.error("[NonIdemRetryExecutor] manipulateRequest error occured: {}", t.getMessage)
        val setStatFuture = Future {
          MysqlPersistence.setFailed(task.getPrimary)
        }
        setStatFuture onComplete {
          case Success(_) =>
          case Failure(e) =>
            log.error("[NonIdemRetryExecutor] setStatFuture error occured: {}", e.getMessage)
        }
        throw t
    }
  }
}
