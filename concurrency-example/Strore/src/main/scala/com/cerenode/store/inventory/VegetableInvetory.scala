package com.cerenode.store.inventory


import com.cerenode.store.Exception.ItemNotFoundException
import com.cerenode.store.models._

import scala.concurrent.{ExecutionContext, Future}

object VegetableInvetory {
  import scala.concurrent.ExecutionContext.Implicits.global
  val tomato = new Tomato(1000)
  val pototo = new Potato(1000)

  val list:List[Vegetable] = List(tomato, pototo)


  def buy(customer: Customer, code:String, quntity:Int):Future[Float] = {

    val item:Option[Vegetable] = list.find(_.code == code)
    item match {
      case Some(f) => Future {
        Thread.sleep(1000)
        f.decrementStock(quntity)
        (f.price * quntity)
      }
      case None => Future.failed(ItemNotFoundException(s"There is no Item found with $code"))
    }
  }



}
