package com.chaos.dr.strange.core.models

/**
  * Created by zcfrank1st on 13/02/2017.
  */
final case class Task (typ: Int, delayTime: Long ,reqTyp: String, reqUrl: String, reqContent: String)

import scalikejdbc._

case class Record(executeTime: String, task: Task)

object Record extends SQLSyntaxSupport[Record] {
  override val tableName = "records"
  def apply(rs: WrappedResultSet): Record = new Record(
    rs.string("execute_time"), Task(
      rs.int("typ"),
      rs.long("delay_time"),
      rs.string("req_typ"),
      rs.string("req_url"),
      rs.string("req_content")))
}