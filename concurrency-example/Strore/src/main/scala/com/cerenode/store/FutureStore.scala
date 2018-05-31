package com.cerenode.store

import com.cerenode.store.inventory.{Inventory, VegetableInvetory}
import com.cerenode.store.models._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

import scala.util.control.NonFatal

object FutureStore extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  val customer = new Customer("abcd", "Gokul", "dfds")

  ///////////////////////////////////////
  /*

  val res2:Future[Float] = VegetableInvetory.buy(customer, VegCode.tomato, 2)
  res2.onComplete {
    case Success(x) => println(s"Price = $x")
    case Failure(err) => println(err.getMessage)
  }

  val res:Future[Float] = VegetableInvetory.buy(customer, "dsfdsf", 2)
  res.onComplete {
    case Success(x) => println(s"Price = $x")
    case Failure(err) => println(err.getMessage)
  }


  Thread.sleep(10000)
  */
/////////////////////////////////

  // Await

/*
  val res1:Future[Float] = VegetableInvetory.buy(customer, VegCode.potato, 2)

  val res2:Future[Float] = VegetableInvetory.buy(customer, VegCode.potato, 2)

  // val res3:Future[Float] = VegetableInvetory.buy(customer, "dsfsdf", 2)

  val resFuture:Future[List[Float]] = Future.sequence(List(res1, res2))

  val res = Await.result(resFuture, Duration.Inf)

  println(res.fold(0.0f)(_+_))

*/




//////////////////////////////////

  // Filtering
  /*
  val res1:Future[Float] = VegetableInvetory.buy(customer, VegCode.potato, 2)

  val res2:Future[Float] = VegetableInvetory.buy(customer, VegCode.potato, 2)

  val res3:Future[Float] = VegetableInvetory.buy(customer, "dsfsdf", 2)

  val list = List(res1, res2, res3)

  val handleErrors = list.map(_.recover {
    case NonFatal(e) => 0.0f
  })

  val resFuture:Future[List[Float]] = Future.sequence(handleErrors)

  val res = Await.result(resFuture, Duration.Inf)

  println(res.fold(0.0f)(_+_))
  */


////////////////////////////////




// compose with other function

  /*

  def printCost(cost:Float) = println(s"Total cost $cost")

  val res:Future[Float] = VegetableInvetory.buy(customer, VegCode.tomato, 2)

  res map printCost

  Thread.sleep(2000)


  */

}
