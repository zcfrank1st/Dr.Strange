package com.chaos.dr.strange.api.models

/**
  * Created by zcfrank1st on 14/02/2017.
  */
final case class Task (typ: Int, delayTime: Option[Long] = None ,reqTyp: String, reqUrl: String, reqContent: Option[String])
