package com.cerenode.store

import com.cerenode.store.models.Customer

package object akka {

  case class CustomerReq(customer:Customer, list:List[(String, Int)])

  case class VegetableReq(customer:Customer,code :String, quantiy:Int)

  case class FruitReq(customer:Customer,code :String, quantiy:Int)

}
