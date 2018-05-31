package com.cerenode.store.models

import com.cerenode.store.Exception.{InvalidCustomerException, ItemNotFoundException}


class Customer(id:String, name:String, mobile:String)

object Customer {

  @throws(classOf[InvalidCustomerException])
  def apply(id: String, name: String, mobile: String): Customer = {
    if(!valiDateMobileNumber) {
       throw InvalidCustomerException("invalid mobile number")
    }
    new Customer(id, name, mobile)
  }


  def valiDateMobileNumber:Boolean = true

  def getProdutsBroughtByCustomer(customer_id: String):List[Item] = ???


}
