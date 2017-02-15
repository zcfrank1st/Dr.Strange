package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging}
import com.chaos.dr.strange.core.actors.store.{MysqlStore, Store}
import com.chaos.dr.strange.model.Task


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Record extends Actor with ActorLogging {

  override def receive: Receive = {
    case task : Task.TaskProto =>
      implicit val store = MysqlStore
      recordFailed(task)

    case _ => // nothing
  }

  def recordFailed (task: Task.TaskProto)(implicit store: Store): Unit = {
    store.keep(task)
  }
}
