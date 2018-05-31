package com.cerenode.store.akka.actors

import akka.pattern.{ask, pipe}
import akka.actor._
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import com.cerenode.store.akka._
import com.cerenode.store.models._

class ItemsActor extends Actor {
  implicit val timeout = Timeout(60.seconds)
  val buyerActor = context.actorOf(Props[BuyerActor])
  def receive = {
    case req:CustomerReq => {

      val (vegList, fruitList) = parseReq(req)

      val fr: List[Future[Float]] =  vegList.map { req =>
        (buyerActor ask req).mapTo[Float]
      }

      val ve: List[Future[Float]] =  fruitList.map { req =>
        (buyerActor ask req).mapTo[Float]
      }


      Future.sequence(fr ++ ve) pipeTo sender
    }
  }


  def parseReq(req:CustomerReq):(List[VegetableReq], List[FruitReq]) = {

    // impliment

    val vegList = List(VegetableReq(req.customer, VegCode.tomato, 2), VegetableReq(req.customer, VegCode.potato, 1))
    val fruitList = List(FruitReq(req.customer, FruitCode.apple, 2))

    (vegList, fruitList)


  }
}


