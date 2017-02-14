package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.Cluster
import com.chaos.dr.strange.core.models.Task
import com.google.gson.Gson


/**
  * Created by zcfrank1st on 08/02/2017.
  */

/**
  *  typ : 0 => 任务直接异步执行
  *  typ : 1 => 任务定时异步执行
  */
class Manager extends Actor with ActorLogging {
  val cluster = Cluster(context.system)
  val gson = new Gson

  def receive: Receive = {
    case task: String =>
      val t: Task = gson.fromJson(task, classOf[Task])
      if (0 == t.typ) {
        val executor = context.actorOf(Props[Executor])
        executor ! t
      } else if (1 == t.typ) {
        val scheduler = context.actorOf(Props[Scheduler])
        scheduler ! t
      }
    case _ =>
  }
}