package com.chaos.dr.strange.core

import akka.cluster.Cluster
import com.chaos.dr.strange.core.actors.Manager
import com.chaos.dr.strange.module.register.Register
//import com.chaos.dr.strange.meta.application

/**
  * Created by zcfrank1st on 08/02/2017.
  */
//@application(entrance = "com.chaos.dr.strange.core.actors.Manager")
//object Main

object Core extends App with Register {
  import akka.actor._
  import akka.cluster.client.ClusterClientReceptionist

  val system = ActorSystem("ClusterSystem")

  val seeds = RedisRegister.availableRegisters().toList
  if (seeds.isEmpty) {
    val address = Cluster(system).selfAddress
    Cluster(system).join(address)
    RedisRegister.register(address.port.get)
  } else {
    val seedsAddress = seeds map { addr =>
      AddressFromURIString(s"akka.tcp://ClusterSystem@$addr")
    }
    val cluster = Cluster(system)
    cluster.joinSeedNodes(seedsAddress)
    RedisRegister.register(cluster.selfAddress.port.get)
  }

  val manager = system.actorOf(Props[Manager], "manager")
  ClusterClientReceptionist(system).registerService(manager)
}