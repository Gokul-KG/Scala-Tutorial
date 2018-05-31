package com.cerenode.store.akka

import akka.actor._
import akka.pattern.ask
import com.cerenode.store.akka.actors.ItemsActor
import com.cerenode.store.models._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import akka.util.Timeout
import scala.concurrent.duration._
object AkkaStroe extends App {

  implicit val timeout = Timeout(60.seconds)
  val actorSystem = ActorSystem("AkkaStroe")

  val actor = actorSystem.actorOf(Props[ItemsActor])
  val customer = new Customer("abcd", "Gokul", "dfds")
  val list = List((VegCode.tomato, 4), (VegCode.potato,2), (FruitCode.apple, 1))

  val req = CustomerReq(customer, list)

  val response: Future[List[Float]] = (actor ? req).mapTo[List[Float]]
  response.onComplete{
    case Success(t) => println("total cost  :  "+t.fold(0.0f)(_ + _))
                       
    case Failure(t) => println("Failed")
                       
  }

  Await.result(response, Duration.Inf)
  actorSystem.stop(actor)
  actorSystem.terminate()



}
