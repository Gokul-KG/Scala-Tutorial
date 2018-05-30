package com.cerenode.store
import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util.Date

import com.sun.javaws.exceptions.InvalidArgumentException
trait Item {
  def price:Float
  def code:String
  def discount : Float
  def decrementStock(quantity:Int)
  def save:Unit
}

trait Vegetable extends Item {
  override def discount: Float = { price * 0.10f }
}

trait Fruit extends Item {

}

@SerialVersionUID(123L) // 123L is random number
class Apple(val code:String, val price:Float, private var _current_stock: Int ) extends Fruit with Serializable {

  override def discount: Float =  { if(_current_stock > 100) price * 0.20f else price * 0.10f }
  def decrementStock(quantity:Int):Unit = {
    _current_stock -= quantity
  }

  def save = {
    val oos = new ObjectOutputStream(new FileOutputStream("/tmp/nflx"))
    oos.writeObject(this)
    oos.close
  }
}

object Apple {
  def apply()= {

    val ois = new ObjectInputStream(new FileInputStream("<file_path>"))
    ois.readObject.asInstanceOf[Apple]
  }

   def getItem = apply().asInstanceOf[Item]

}


class Carrot(val code:String, val price:Float, private  var _current_stock: Int ) extends Vegetable with Serializable{

  def decrementStock(quantity:Int) = {
    _current_stock -= quantity
  }
  def save = {
    val oos = new ObjectOutputStream(new FileOutputStream("<file_path>"))
    oos.writeObject(this)
    oos.close
  }
}

object Carrot {
  def apply()= {

    val ois = new ObjectInputStream(new FileInputStream("<file_path>"))
    ois.readObject.asInstanceOf[Carrot]
  }

  def getItem = apply().asInstanceOf[Item]
}


class Customer(id:String, name:String, mobile:String)



object Customer {

  @throws(classOf[InvalidArgumentException])
  def apply(id: String, name: String, mobile: String): Customer = {
    //if(!valiDateMobileNumber) throw InvalidArgumentException
    new Customer(id, name, mobile)
  }


  def valiDateMobileNumber:Boolean = ???

  def getProdutsBroughtByCustomer(customer_id: String):List[Item] = ???


}


case class Transaction(item_code: String,customer_id:String, quantity:Int, dateOfPurchase:Date)

object Transaction {

   def getAllTransaction():List[Transaction] = ??? // read from file


}

object Inventary  {

  lazy val items:List[Item] = List(Apple.getItem, Carrot.getItem)

  def getItemByCode(code:String):Option[Item] = items.find(_.code == code)

  def saveAll = {
    items.map(_.save)
  }
}

