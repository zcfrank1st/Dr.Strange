package com.chaos.dr.strange.core

import akka.cluster.Cluster
import com.chaos.dr.strange.core.actors.Manager
//import com.chaos.dr.strange.meta.application

/**
  * Created by zcfrank1st on 08/02/2017.
  */
//@application(entrance = "com.chaos.dr.strange.core.actors.Manager")
//object Main

object Main extends App {
  import akka.actor._
  import akka.cluster.client.ClusterClientReceptionist

  val system = ActorSystem("ClusterSystem")
  val address = Cluster(system).selfAddress
  Cluster(system).join(address)
  val manager = system.actorOf(Props[Manager], "manager")
  ClusterClientReceptionist(system).registerService(manager)

  // TODO 启动多个实例
  // TODO 动态加载cluster seed
}