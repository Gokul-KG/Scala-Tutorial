package com.cerenode.store

import com.cerenode.store.models._

object Stroe extends App {
   val customer = new Customer("abcd", "Gokul", "dfds")


   //(1 to 1001).par.foreach(x => Inventory.buyFruit(customer,"APPLE", 1))

   //println(Inventory.apple._stock)


  // using future

/*

   println(Inventory.apple._stock)
   val futureResult = (1 to 1002).map(x =>Future {
         Inventory.buyFruit(customer, "APPLE", 1)
      })


   Future.sequence(futureResult).onComplete {
      case Success(s) =>  println(Inventory.apple._stock)
      case Failure(s) =>  println("Failed")
   }
   println("Completd")
   println(Inventory.apple._stock)


  */










   // composing future

   /*
   val customer = new Customer("abcd", "Gokul", "dfds")

  def printfailedTransaction(x:Future[Boolean]) = {
    x.onComplete {
      case Success(x) =>
      case Failure(x) => println(x)
    }
  }


  println(Inventory.apple._stock)

  val futureResult = (1 to 1002).map(x =>Future {
    Inventory.buyFruit(customer, "APPLE", 1)
  })


  futureResult map printfailedTransaction
    */


}
