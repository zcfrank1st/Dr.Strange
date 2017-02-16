package com.chaos.dr.strange.module.meta

import scala.annotation.StaticAnnotation

/**
  * Created by zcfrank1st on 08/02/2017.
  */
import scala.meta._

class application(entrance: String) extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    val arg = this match {
      case q"new $_(entrance = ${Lit(entrance: String)})" => entrance
      case q"new $_(${Lit(entrance: String)})" => entrance
      case _ => abort("@application transform wrong")
    }

    val q"object $name" = defn

    val imports = s"import $arg".parse[Stat].get

    val argList = arg.split("\\.")
    val typString = argList(argList.size - 1)
    val typ = typString.parse[Type].get

    val main =
      q"""
         $imports
         import akka.actor._
         import akka.cluster.client.ClusterClientReceptionist

         class Terminator(ref: ActorRef) extends Actor with ActorLogging {
             context watch ref
             def receive = {
               case Terminated(_) =>
                 log.info("{} has terminated, shutting down system", ref.path)
                 context.system.terminate()
             }
         }

         val system = ActorSystem("ClusterSystem")
         val manager = system.actorOf(Props[$typ], "manager")
         ClusterClientReceptionist(system).registerService(manager)
         system.actorOf(Props(classOf[Terminator], manager), "terminator")
       """


    q"""
        object $name extends App {
          $main
        }
    """
  }
}