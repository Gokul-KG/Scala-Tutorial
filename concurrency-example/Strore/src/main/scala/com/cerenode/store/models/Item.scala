package com.cerenode.store.models

trait Item {
  def price:Float
  def code:String
  def discount : Float
  def decrementStock(quantity:Int)
}

