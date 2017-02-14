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
          val resp = Request.Get(res).execute()
          manipulateResponse(resp)

        case "post" =>
          val resp = Request.Post(res).bodyString(ctnt, ContentType.APPLICATION_JSON).execute()
          manipulateResponse(resp)

        case "put" =>
          val resp = Request.Put(res).bodyString(ctnt, ContentType.APPLICATION_JSON).execute()
          manipulateResponse(resp)

        case "delete" =>
          val resp =
            Request.Delete(res).execute()
          manipulateResponse(resp)
      }

    case _ => // nothing
  }

  def manipulateResponse(response: Response)(implicit task: Task): Unit = {
    if (200 != response.returnResponse().getStatusLine.getStatusCode) {
      val record = context.actorOf(Props[Record])
      record ! task
    }
  }
}
