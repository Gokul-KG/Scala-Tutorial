package com.cerenode

package object fruitstore {
  case class Transaction(tansId: String, itemCode: String, qty: Int, total: Float, custId: String, itemType: String)
  case class Customer(custId: String, number: Long)
  def lineSplit(s: String) = s.split(",")

}