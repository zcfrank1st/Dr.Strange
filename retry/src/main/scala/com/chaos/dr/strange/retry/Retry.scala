package com.chaos.dr.strange.retry

import akka.actor.{ActorSystem, Props}
import com.chaos.dr.strange.module.executor.RetryExecutor
import com.chaos.dr.strange.module.persistence.Persistence

/**
  * Created by zcfrank1st on 16/02/2017.
  */
object Retry extends App with Persistence {
  val system = ActorSystem("retry")

  import system.dispatcher
  import scala.concurrent.duration._

  // FIXME 不幂等情况下多次执行如何规避 （数据库增加幂等字段标明，幂等只执行一次）
  system.scheduler.schedule(0 seconds, 5 minutes, system.actorOf(Props[RetryExecutor]), MysqlPersistence.retrieveIdemFails())
}
