package com.chaos.dr.strange.core.models

/**
  * Created by zcfrank1st on 13/02/2017.
  */
case class Task (typ: Int, delayTime: Option[Long] = None ,reqTyp: String, reqUrl: String, reqContent: String)
case class Record(executeTime: String, task: Task)