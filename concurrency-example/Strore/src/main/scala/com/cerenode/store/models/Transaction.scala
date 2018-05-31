package com.cerenode.store.models

import java.util.Date

case class Transaction(item_code: String,customer_id:String, quantity:Int, dateOfPurchase:Date)

object Transaction {

  def getAllTransaction():List[Transaction] = ??? // read from file


}