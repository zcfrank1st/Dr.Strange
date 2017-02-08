package com.chaos.dr.strange.meta

import scala.annotation.StaticAnnotation

/**
  * Created by zcfrank1st on 08/02/2017.
  */
import scala.meta._

class application extends StaticAnnotation {
  inline def apply(defn: Any): Any = meta {
    val q"object $name" = defn
    val main =
      q"""
         println("hello world")
       """
    q"object $name extends App { $main }"
  }
}