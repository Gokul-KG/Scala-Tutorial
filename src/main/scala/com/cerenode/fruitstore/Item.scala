package com.cerenode.fruitstore

trait Item {
  // common functions

}

class Fruits(name: String, price: Float, var stock: Int) extends Item {

}

class Vegetables(name: String, price: Float, var stock: Int) extends Item {

}

