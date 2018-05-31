package com.cerenode.store.inventory

import com.cerenode.store.Exception.ItemNotFoundException
import com.cerenode.store.models._

object Inventory {

  val apple = new Apple(1000)
  val orange = new Orange(200)

  val listOfFruits:List[Fruit] = List(apple, orange)


  def buyFruit(customer: Customer, code:String, quntity:Int):Float = {
      val item:Option[Fruit] = listOfFruits.find(_.code == code)
      item match {
        case Some(f) => f.decrementStock(quntity)
          (f.price * quntity)

        case None => throw ItemNotFoundException(s"There is no Item found with $code")
          0f
      }
  }



}
