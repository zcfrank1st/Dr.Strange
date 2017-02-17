package com.chaos.dr.strange.non.idem.retry

import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by zcfrank1st on 17/02/2017.
  */
object NonIdemRetry extends App {
  // TODO 不幂等情况下执行  List[Future[T]] => Future[List[T]]  Future.sequence

  import scala.concurrent.ExecutionContext.Implicits.global


  val f1 = Future {
    1
  }

  val f2 = Future {
    2
  }

  val f3 = Future {
    1
  }

  val res = for {
    a1 <- f1
    a2 <- f2
    a3 <- f3
  } yield (a1, a2, a3)

  res onComplete {
    case Success(_) =>
      println(1)
    case Failure(_) => println(2)
  }

  while (!res.isCompleted) {
    println("not finished")
  }

}
