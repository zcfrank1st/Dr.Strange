package com.chaos.dr.strange.module.meta

import scala.annotation.StaticAnnotation

/**
  * Created by zcfrank1st on 08/02/2017.
  */
import scala.meta._

class app extends StaticAnnotation {

  inline def apply(defn: Any): Any = meta {
    val q"object $name { ..$stats }" = defn

    q"""
        object $name extends App with JsonSupport {
          ..$stats
        }
    """
  }
}