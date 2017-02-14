package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import com.chaos.dr.strange.core.actors.store.{KafkaStore, MysqlStore, Store}
import com.chaos.dr.strange.core.models.Task

import scala.concurrent.Future


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Record extends Actor with ActorLogging {
  override def receive: Receive = {
    case task @ Task(_ ,_ ,_ ,_ ,_) =>
      implicit val store = MysqlStore
      val future = Future {
        recordFailed(task)
      }

      future onFailure {
        case _ =>
          log.error(s"[Failed Task] => $task")
      }

    case _ => // nothing
  }

  def recordFailed (task: Task)(implicit store: Store): Unit = {
    store.keep(task)
  }
}
