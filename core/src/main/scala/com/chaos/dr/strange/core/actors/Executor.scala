package com.chaos.dr.strange.core.actors

import com.chaos.dr.strange.meta.actor

/**
  * Created by zcfrank1st on 08/02/2017.
  */
@actor(0 , "")
class Executor {
  {
    case 1 => println("hello")
    case _ => // noting to do
  }
}
