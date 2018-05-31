package com.cerenode.store


  import com.cerenode.store.inventory.{Inventory, VegetableInvetory}
  import com.cerenode.store.models._

  import scala.concurrent.{Await, Future,Promise}
  import scala.concurrent.duration.Duration
  import scala.util.{Failure, Success, Try}

  import scala.util.control.NonFatal

  object PromiseStore extends App {

    import scala.concurrent.ExecutionContext.Implicits.global

    val customer = new Customer("abcd", "Gokul", "dfds")

    println("purchasing")
    val fruitCost = Promise[Float]()
    val vegetableCost = Promise[Float]()

    val fruitCostFuture = fruitCost.future
    val vegetableCostFuture = vegetableCost.future


    val puchase = Future {

      val fruits:Float = Inventory.buyFruit(customer, FruitCode.apple, 2)

      fruitCost success fruits

      Thread.sleep(3000)
      println("buying vegitables")

      VegetableInvetory.buy(customer, VegCode.tomato, 2) onComplete {
        case Success(cost) => {
          vegetableCost success cost
        }
        case Failure(err) => {
          vegetableCost failure err
        }
      }

    }


    println("Dispatcher Ready")
     val fruitDispatcher = Future {

       fruitCostFuture onComplete {
         case Success(price) => println("Dispatching Fruits")
         case Failure(err) => println("Some Error happend")
       }

     }

    val vegtebleDispatcher = Future {

      vegetableCostFuture onComplete {
        case Success(price) => println("Dispatching vegitable")
        case Failure(err) => println("Some Error happend")
      }

    }


    Await.result(vegetableCostFuture, Duration.Inf)


}
