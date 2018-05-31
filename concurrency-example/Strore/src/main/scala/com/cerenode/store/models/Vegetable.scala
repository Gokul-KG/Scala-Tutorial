package com.cerenode.store.models

import com.cerenode.store.Exception.OutOfStockException

abstract class Vegetable extends Item {

  var _stock:Int

  @throws(classOf[OutOfStockException])
  override def decrementStock(quantity: Int): Unit = {
    if (_stock < quantity)
      throw OutOfStockException(s"${this.getClass.getName} is out of stock")
    else
      _stock -= quantity
  }

  override def discount: Float = ???
}

class Potato(var _stock: Int) extends Vegetable with Item {
  val price:Float = 20.0f
  val code = VegCode.potato
}


class Tomato(var _stock: Int) extends Vegetable with Item {
  val price:Float = 40.0f
  val code = VegCode.tomato
}