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

    def register(port: Int) = {
      jedis.lpush(registerKey, s"${currentIpV4()}:port")
    }

    def unregister(port: Int) = {
      jedis.lrem(registerKey, 0, s"${currentIpV4()}:port")
    }

    def availableRegisters () : List[String] = {
      import scala.collection.JavaConverters._
      jedis.lrange(registerKey, 0, -1).asScala.toList
    }
  }
}
