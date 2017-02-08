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
      case _                                                => // nothing to do
    }
    println(s"Arg is $arg")

    val q"object $name" = defn
    val main =
      q"""
         println("hello world")
       """
    q"object $name extends App { $main }"
  }
}

class actor(typ: Int) extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    val arg = this match {
      case q"new $_(${Lit(typ: Int)})" => typ
      case _                                                => // nothing to do
    }

    val q"class $name extends Actor { ..$body }" = defn

    arg match {
      case 0 => defn
      case 1 => q"class $name extends PersistentActor { ..$body }"
    }
  }
}