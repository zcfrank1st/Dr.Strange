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

class actor(typ: Int, depends: String) extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    val arg = this match {
      case q"new $_(${Lit(typ: Int)}, ${Lit(depends: String)})" => (typ, depends)
      case _                                                => // nothing to do
    }
    println(s"Arg is $arg")

    val q"class $name { ..$body }" = defn

    q"class $name"
  }
}