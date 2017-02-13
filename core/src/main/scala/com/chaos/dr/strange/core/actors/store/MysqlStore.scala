package com.chaos.dr.strange.core.actors.store
import com.chaos.dr.strange.core.models.Task

/**
  * Created by zcfrank1st on 13/02/2017.
  */
trait MysqlStore extends Store {
  override def keep(task: Task): Unit = {
    // TODO 保存数据库
  }
}

object MysqlStore
