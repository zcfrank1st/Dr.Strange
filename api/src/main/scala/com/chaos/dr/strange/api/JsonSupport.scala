package com.chaos.dr.strange.api

import com.chaos.dr.strange.api.models.Task
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat


/**
  * Created by zcfrank1st on 14/02/2017.
  */
trait JsonSupport {
  implicit val creatureFormat: RootJsonFormat[Task] = jsonFormat5(Task)
}
