package com.chaos.dr.strange.core.actors

import akka.actor.{Actor, ActorLogging}
import akka.cluster.Cluster


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Manager extends Actor with ActorLogging {
  val cluster = Cluster(context.system)

  def receive = {
    case _ => // nothing
  }
}