package com.chaos.dr.strange.core.actors.store
import com.chaos.dr.strange.core.models.Task
import org.joda.time.DateTime

/**
  * Created by zcfrank1st on 13/02/2017.
  */
trait MysqlStore extends Store {
  import scalikejdbc._

  Class.forName("com.mysql.jdbc.Driver")
  ConnectionPool.singleton("jdbc:mysql://192.168.33.220:3306/test", "djdev", "djDev123456;")

//  // ad-hoc session provider on the REPL
//  implicit val session = AutoSession

  override def keep(task: Task): Unit = {
    val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
    sql"insert into records (execute_time, typ, delay_time, req_typ, req_url, req_content) values (${now}, ${task.typ}, ${task.delayTime}, ${task.reqTyp}, ${task.reqUrl}, ${task.reqContent})".update().apply()
  }
}

object MysqlStore
