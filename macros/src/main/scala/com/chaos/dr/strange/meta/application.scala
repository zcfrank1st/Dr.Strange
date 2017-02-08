package com.chaos.dr.strange.meta

import scala.annotation.StaticAnnotation

/**
  * Created by zcfrank1st on 08/02/2017.
  */
import scala.meta._

class application(entrance: String) extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    val arg = this match {
      case q"new $_(${Lit(entrance: String)})" => entrance
      case _ => abort("@application transform wrong")
    }

    val q"object $name" = defn


    val imports = s"import $arg".parse[Stat].get

    val main =
      q"""
        println("hello world  1231231")
        println("666")
        $imports
        Manager.p
       """


    q"""
        object $name extends App {
          $main
        }
    """
  }
}