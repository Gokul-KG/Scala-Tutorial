package com.cerenode.store.akka.actors

import akka.pattern.{ask, pipe}
import akka.actor._
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import com.cerenode.store.akka._
import com.cerenode.store.inventory.{Inventory, VegetableInvetory}
import com.cerenode.store.models._
import akka.pattern.pipe

class BuyerActor extends Actor {
  implicit val timeout = Timeout(60.seconds)

  override def receive: Receive = {

    case req:VegetableReq => VegetableInvetory.buy(req.customer,req.code, req.quantiy) pipeTo sender

    case vegReq:FruitReq=> sender ! Inventory.buyFruit(vegReq.customer,vegReq.code, vegReq.quantiy)
  }

}
