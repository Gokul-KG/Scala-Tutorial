package com.cerenode.futures

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source
import scala.util.{Failure, Success}
import scala.util.Random

object Futures1 extends App {
  def f1: Unit = {
    println("starting calculation ...")
    val f = Future {
      sleep(Random.nextInt(500))
      "stinrg"
    }
    println("before onComplete")
    f.onComplete {
      case Success(value) => println(s"Got the callback, meaning = $value")
      case Failure(e) => e.printStackTrace()
    }
    // do the rest of your work
    println("A ..."); sleep(100)
    println("B ..."); sleep(100)
    println("C ..."); sleep(100)
    println("D ..."); sleep(100)
    println("E ..."); sleep(100)
    println("F ..."); sleep(100)
    sleep(2000)
  }

  def f2: Unit = {
    val f = Future {
      sleep(Random.nextInt(500))
      if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
    }
    f onSuccess {
      case result => println(s"Success: $result")
    }
    f onFailure {
      case t => println(s"Exception: ${t.getMessage}")
    }

    // do the rest of your work
    println("A ...")
    sleep(100)
    println("B ..."); sleep(100)
    println("C ..."); sleep(100)
    println("D ..."); sleep(100)
    println("E ..."); sleep(100)
    println("F ..."); sleep(100)
    sleep(2000)
  }

//  f1
//  f2

  def f3: Unit = {
    val link = "https://en.wikipedia.org/wiki/2017%E2%80%9318_UEFA_Champions_League"
    val getReq = Source.fromURL(link)
    println(getReq.mkString)
  }

  f1
}

object RunningMultipleCalcs extends App {
  println("starting futures")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)

  println("before onSuccess")
  result.onComplete {
    case Success(result) => println(s"total = $result")
    case Failure(ev) => ev.printStackTrace()
  }

  println("before sleep at the end")
  sleep(2000)  // important: keep the jvm alive
}

object Cloud {
  def runAlgorithm(i: Int): Future[Int] = Future {
    sleep(Random.nextInt(500))
    val result = i + 10
    println(s"returning result from cloud: $result")
    result
  }
}