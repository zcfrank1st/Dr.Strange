package com.chaos.dr.strange.core.actors

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorLogging, Props}
import com.chaos.dr.strange.module.executor.Executor
import com.chaos.dr.strange.module.model.proto.Task

import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration

/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Scheduler extends Actor with ActorLogging{
  implicit val ec: ExecutionContext = context.dispatcher

  override def receive: Receive = {
    case task : Task.TaskProto =>
      val delayTime = task.getDelayTo - System.currentTimeMillis
      
      if (delayTime > 0) {
        val executor = context.system.actorOf(Props[Executor])
        context.system.scheduler.scheduleOnce(Duration.create(delayTime, TimeUnit.MILLISECONDS), executor, task)
      } else {
        val executor = context.system.actorOf(Props[Executor])
        executor ! task
      }

    case _ => // nothing
  }
}
