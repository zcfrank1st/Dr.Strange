package com.chaos.dr.strange.module.model.db

import com.chaos.dr.strange.module.model.proto.Task

/**
  * Created by zcfrank1st on 13/02/2017.
  */

final case class Record(id:Int, createTime: String, task: Task.TaskProto, status: Int)