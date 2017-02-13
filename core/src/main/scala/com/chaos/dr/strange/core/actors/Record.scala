package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging}
import com.chaos.dr.strange.core.actors.store.{KafkaStore, Store}
import com.chaos.dr.strange.core.models.Task


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Record extends Actor with ActorLogging {
  override def receive: Receive = {
    case task @ Task(_ ,_ ,_ ,_ ,_) =>
      implicit val store = KafkaStore
      recordFailed(task)

    case _ => // nothing
  }

  def recordFailed (task: Task)(implicit store: Store): Unit = {
    store.keep(task)
  }
}
