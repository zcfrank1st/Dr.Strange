package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.Cluster
import com.chaos.dr.strange.core.models.Task


/**
  * Created by zcfrank1st on 08/02/2017.
  */

/**
  *  typ : 0 => 任务直接异步执行
  *  typ : 1 => 任务定时异步执行
  */
class Manager extends Actor with ActorLogging {
  val cluster = Cluster(context.system)

  def receive: Receive = {
    case task @ Task(typ, _, _, _, _) =>
      if (0 == typ) {
        val executor = context.actorOf(Props[Executor])
        executor ! task
      } else if (1 == typ) {
        val scheduler = context.actorOf(Props[Scheduler])
        scheduler ! task
      }
    case _ => // nothing
  }
}