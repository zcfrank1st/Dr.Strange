package com.chaos.dr.strange.module.persistence

import com.chaos.dr.strange.module.model.db.Record
import com.chaos.dr.strange.module.model.proto.Task.TaskProto
import com.typesafe.config.{Config, ConfigFactory}
import org.joda.time.DateTime

/**
  * Created by zcfrank1st on 16/02/2017.
  */
trait Persistence {
  val conf: Config = ConfigFactory.load()

  object MysqlPersistence {
    import scalikejdbc._

    Class.forName("com.mysql.jdbc.Driver")
    ConnectionPool.singleton(conf.getString("persistence.mysql.connection"), conf.getString("persistence.mysql.username"), conf.getString("persistence.mysql.password"))

    implicit val session = AutoSession

    object Record extends SQLSyntaxSupport[Record] {
      override val tableName = conf.getString("persistence.mysql.tablename")
      def apply(rs: WrappedResultSet) = new Record(
        rs.string("id"),
        TaskProto.newBuilder().setDelayTo(rs.long("delay_to")).setReqContent(rs.string("req_content")).setReqTyp(rs.string("req_typ")).setReqUrl(rs.string("req_url")).setTyp(rs.int("typ")).build(),
        rs.int("status")
      )
    }

    def keep(task: com.chaos.dr.strange.module.model.api.Task): String = {
      val now = DateTime.now().toString("yyyyMMddHHmmss")

      sql"""
      insert into records
      (id, typ, delay_to, req_typ, req_url, req_content, status)
      values
      (${now}, ${task.typ}, ${task.delayTo}, ${task.reqTyp}, ${task.reqUrl}, ${task.reqContent}, 0)
      """.update.apply()

      now
    }

    def setFailed(primaryKey: String): Unit = {
      sql"update records set status = 1 where id = ${primaryKey}".update().apply()
    }

    def clearSuccess(primaryKey: String): Unit = {
      sql"delete records where id = ${primaryKey}".update.apply()
    }

    def retrieveFails(): List[Record] = {
      sql"select * from records where status = 1".map(rs => Record(rs)).list.apply()
    }
  }

}
