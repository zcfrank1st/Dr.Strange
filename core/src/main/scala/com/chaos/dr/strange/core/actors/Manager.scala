package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent._
import com.chaos.dr.strange.module.executor.Executor
import com.chaos.dr.strange.module.model.proto.Task
import com.chaos.dr.strange.module.register.Register


/**
  * Created by zcfrank1st on 08/02/2017.
  */

/**
  *  typ : 0 => 任务直接异步执行
  *  typ : 1 => 任务定时异步执行
  */
class Manager extends Actor with ActorLogging with Register {
  val cluster = Cluster(context.system)

  override def preStart(): Unit = {
    cluster.subscribe(self, initialStateMode = InitialStateAsEvents,
      classOf[MemberEvent], classOf[UnreachableMember])
  }
  override def postStop(): Unit = cluster.unsubscribe(self)

  def receive: Receive = {
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
      RedisRegister.register(member.address.port.get)
    case MemberLeft(member) =>
      log.warning("Member is Left: {}", member.address)
      RedisRegister.unregister(member.address.port.get)
    case ReachableMember(member) =>
      log.warning("Member detected as Reachable: {}", member)
      RedisRegister.register(member.address.port.get)
    case UnreachableMember(member) =>
      log.warning("Member detected as Unreachable: {}", member)
      RedisRegister.unregister(member.address.port.get)
    case _: Throwable =>
      log.warning("[Manager] receive message error")
  }
}