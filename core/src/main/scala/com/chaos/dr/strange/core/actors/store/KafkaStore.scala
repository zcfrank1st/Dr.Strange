package com.chaos.dr.strange.core.actors.store
import com.chaos.dr.strange.core.models.Task

/**
  * Created by zcfrank1st on 13/02/2017.
  */
trait KafkaStore extends Store {
  override def keep(task: Task): Unit = ???
}

object KafkaStore