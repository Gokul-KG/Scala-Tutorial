package com.cerenode.futures

// 1 - the imports
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Futures extends App {

  // used by 'time' method
  implicit val baseTime = System.currentTimeMillis

  // 2 - create a Future
  val f = Future {
    println("Printing in future")
    sleep(500)
    1 + 1
  }

  val f2 = Future {
    println("Printing in future2")
    sleep(500)
    1 + 3
  }

  // 3 - this is blocking (blocking is bad)
  println("text after future1")
  val result = Await.result(f, 100 millisecond)
  println("text after future2")
  val result2 = Await.result(f2, 1 second)
  println(result)
  println("text after future3")
  println(result2)
  sleep(4000)
  println("text after future4")

}