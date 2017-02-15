package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.{MemberRemoved, MemberUp, UnreachableMember}
import com.chaos.dr.strange.model.Task
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
    //    case task: String =>
    //      val t: Task = gson.fromJson(task, classOf[Task])
    //      if (0 == t.typ) {
    //        val executor = context.actorOf(Props[Executor])
    //        executor ! t
    //      } else if (1 == t.typ) {
    //        val scheduler = context.actorOf(Props[Scheduler])
    //        scheduler ! t
    //      }
    case task: Task.TaskProto =>
      if (0 == task.getTyp) {
        val executor = context.actorOf(Props[Executor])
        executor ! task
      } else if (1 == task.getTyp) {
        val scheduler = context.actorOf(Props[Scheduler])
        scheduler ! task
      }
    case MemberUp(member) =>
      log.info("Member is Up: {}", member.address)
    case UnreachableMember(member) =>
      log.info("Member detected as Unreachable: {}", member)
    case MemberRemoved(member, previousStatus) =>
      log.info("Member is Removed: {} after {}", member.address, previousStatus)
    case _ =>
  }
}