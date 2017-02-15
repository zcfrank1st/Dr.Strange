package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import com.chaos.dr.strange.core.models.Task
import org.apache.http.client.fluent.{Request, Response}
import org.apache.http.entity.ContentType

/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Executor extends Actor with ActorLogging {
  override def receive: Receive = {
    case task @ Task(_, _, typ, res, ctnt) =>
      typ.toLowerCase match {
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

    case _ => // nothing
  }

  def manipulateRequest(req: Request)(implicit task: Task): Unit = {
    try {
      req.connectTimeout(3).execute()
    } catch {
      case _ =>
        val record = context.actorOf(Props[Record])
        record ! task
    }
  }
}
