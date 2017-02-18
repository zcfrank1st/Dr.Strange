package com.chaos.dr.strange.non.idem.retry

import akka.actor.{ActorSystem, Props}
import com.chaos.dr.strange.module.executor.NonIdemRetryExecutor

/**
  * Created by zcfrank1st on 17/02/2017.
  */
object NonIdemRetry extends App {
  val nonIdemRetry = ActorSystem("NonIdemRetry")
    .actorOf(Props[NonIdemRetryExecutor])

  nonIdemRetry ! "start"
}
