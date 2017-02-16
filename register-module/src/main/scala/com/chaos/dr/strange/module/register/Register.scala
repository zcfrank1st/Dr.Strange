package com.chaos.dr.strange.module.register

import java.net.{Inet4Address, InetAddress, NetworkInterface}

import com.typesafe.config.{Config, ConfigFactory}
import redis.clients.jedis.Jedis
import scala.collection.JavaConversions._

/**
  * Created by zcfrank1st on 16/02/2017.
  */
trait Register {
  val conf: Config = ConfigFactory.load()

  object RedisRegister {
    val jedis: Jedis = new Jedis(conf.getString("register.redis.host"), conf.getInt("register.redis.port"))
    val registerKey = "Cluster_Registry"

    private def currentIpV4 (): String = {
      NetworkInterface.getNetworkInterfaces
        .filter(iface => iface.isUp && !iface.isLoopback && iface.getInetAddresses.hasMoreElements)
        .foldLeft(List.empty[InetAddress])((acc, iface) =>
          iface.getInetAddresses.foldLeft(acc) { (addresses, address) => address :: addresses }
        )
        .filter(_.isInstanceOf[Inet4Address])
        .filter(_.isSiteLocalAddress)
        .map(_.getHostName)
        .head
    }

    def register(port: Int): Unit = {
      jedis.sadd(registerKey, s"${currentIpV4()}:port")
    }

    def unregister(port: Int): Unit = {
      jedis.srem(registerKey, s"${currentIpV4()}:port")
    }

    def availableRegisters () : Set[String] = {
      import scala.collection.JavaConverters._
      jedis.smembers(registerKey).asScala.toSet
    }
  }
}
