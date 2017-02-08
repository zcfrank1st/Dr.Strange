package com.chaos.dr.strange.core.actors

import akka.actor.Actor
import akka.actor.Actor.Receive


/**
  * Created by zcfrank1st on 08/02/2017.
  */
class Manager extends Actor {
  override def receive: Receive = {
    case 0 => println("hello world")
    case _ => // nothing to do
  }
}
