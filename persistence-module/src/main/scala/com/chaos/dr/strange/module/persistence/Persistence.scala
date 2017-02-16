package com.chaos.dr.strange.module.persistence

import com.chaos.dr.strange.module.model.api.Task
import com.chaos.dr.strange.module.model.db.Record
import com.chaos.dr.strange.module.model.proto.Task.TaskProto
import com.typesafe.config.{Config, ConfigFactory}

import scala.concurrent.Future

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
        rs.int("id"),
        rs.string("create_time"),
        TaskProto.newBuilder().setDelayTo(rs.long("delay_to")).setReqContent(rs.string("req_content")).setReqTyp(rs.string("req_typ")).setReqUrl(rs.string("req_url")).setTyp(rs.int("typ")).build(),
        rs.int("status")
      )
    }

    // TODO 补全操作
    def keep(task: Task): Future[Option[Int]] = {
      Future { Some(1) }
    }

    def setStatus(status: Int): Unit = {

    }

    def remove(primaryKey: Int): Unit = {

    }

    def retrieve() = Option[Record] {
      Nothing
    }
  }

}
