import com.typesafe.config.ConfigFactory

/**
  * Created by zcfrank1st on 15/02/2017.
  */
object ConfigTest extends App {
  val conf = ConfigFactory.parseString("current=666").withFallback(ConfigFactory.load("app"))

  println(conf.getInt("url"))
  println(conf.getInt("current"))
}
