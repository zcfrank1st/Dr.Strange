package com.chaos.dr.strange.core.models

/**
  * Created by zcfrank1st on 13/02/2017.
  */
import com.chaos.dr.strange.model.Task
import com.chaos.dr.strange.model.Task.TaskProto
import scalikejdbc._

case class Record(executeTime: String, task: Task.TaskProto)

object Record extends SQLSyntaxSupport[Record] {
  override val tableName = "records"
  def apply(rs: WrappedResultSet): Record = new Record(
    rs.string("execute_time"), TaskProto.newBuilder().setDelayTime(rs.long("delay_time")).setReqContent(rs.string("req_content")).setReqTyp(rs.string("req_typ")).setReqUrl(rs.string("req_url")).setTyp(rs.int("typ")).build())
}