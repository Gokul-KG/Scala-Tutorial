package com.cerenode.store.models

import com.cerenode.store.Exception._
import sun.font.FontRunIterator
abstract class Fruit extends Item {

  var _stock:Int

  @throws(classOf[OutOfStockException])
  override def decrementStock(quantity: Int): Unit = this.synchronized {
    if (_stock < quantity)
      throw OutOfStockException(s"${this.getClass.getName} is out of stock")
    else
    _stock -= quantity
  }

  override def discount: Float = price * 0.1f
}


class Apple(var _stock: Int) extends Fruit with Item {
  val price:Float = 100.0f
  val code = FruitCode.apple
}


class Orange(var _stock: Int) extends Fruit with Item {
  val price:Float = 80.5f
  val code = FruitCode.orange
}

