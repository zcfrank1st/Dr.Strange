package com.chaos.dr.strange.core.actors

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorLogging}
import com.chaos.dr.strange.core.models.Task


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Record extends Actor with ActorLogging {
  override def receive: Receive = {
    case task @ Task(_ ,_ ,_ ,_ ,_) =>
      recordFailed(task)

    case _ => // nothing
  }

  def recordFailed (task: Task): Unit = {
    // TODO record
  }
}
