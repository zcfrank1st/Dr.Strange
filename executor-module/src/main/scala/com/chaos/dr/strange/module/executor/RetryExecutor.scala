package com.chaos.dr.strange.module.executor

import akka.actor.{Actor, ActorLogging, Props}
import com.chaos.dr.strange.module.model.db.Record

/**
  * Created by zcfrank1st on 16/02/2017.
  */
class RetryExecutor extends Actor with ActorLogging {
  override def receive: Receive = {
    case records: List[Record] =>
      records.foreach(record => {
        val executor = context.actorOf(Props[Executor])
        executor ! record
      })

    case _ => // nothing to do
  }
}