package com.chaos.dr.strange.idem.retry

import akka.actor.{ActorSystem, Props}
import com.chaos.dr.strange.module.executor.RetryExecutor
import com.chaos.dr.strange.module.persistence.Persistence

/**
  * Created by zcfrank1st on 16/02/2017.
  */
object IdemRetry extends App with Persistence {
  val system = ActorSystem("retry")

  import system.dispatcher
  import scala.concurrent.duration._

  system.scheduler.schedule(0 seconds, 5 minutes, system.actorOf(Props[RetryExecutor]), MysqlPersistence.retrieveIdemFails())
}
