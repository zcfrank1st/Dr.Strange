package com.chaos.dr.strange.core.actors.store
import com.chaos.dr.strange.model.Task

/**
  * Created by zcfrank1st on 13/02/2017.
  */
object KafkaStore extends Store {
  override def keep(task: Task.TaskProto): Unit = {
    // TODO pipe to kafka, then consume and then retry
  }
}