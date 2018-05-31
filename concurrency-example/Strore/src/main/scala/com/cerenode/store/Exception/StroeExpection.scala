package com.cerenode.store.Exception

sealed trait StoreException extends Exception {
  self : Throwable =>
  val errorCode:String
  val message:String
  override def getMessage: String = message

}

case class OutOfStockException(message: String) extends StoreException {
   val errorCode= "OUT_STOCK"
}

case class ItemNotFoundException(code:String) extends StoreException {
  override val message: String = s"This $code"
  val errorCode= "OUT_STOCK"
}


case class InvalidCustomerException(code:String) extends StoreException {
  override val message: String = s"not valid"
  val errorCode= "asfas"
}