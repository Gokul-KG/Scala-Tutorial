trait Item {
  // what are the parameters for the trait
  def getName(name:String) = {println(name)}
  def getPrice(price: Float) = {println(price)}
  def getStock(stock: Int) = if (stock<0) {println("INCORRECT ENTRY")} else {println(stock)}

  }


case class Fruit(name: String, price: Float, stock: Int) extends Item {
  def discount: Float = { price * 0.10f }

  def getName: String = name
  def getPrice: Float = price
  def getStock: Int = stock

}
val fr = new Fruit("Apple",4.5f,3)
fr.getName

// discount for fruit and vegetable are calculated differently

class Vegetable(name: String, stock: Int, price: Float) extends Item {
  def discountConstrained: Float = { if(stock > 100) price * 0.20f else price * 0.10f }
  def getName: String = name
  def getPrice: Float = price
  def getStock: Int = stock
}

def getDiscount(obj: Item) = {
  val g = obj match {
    case a: Fruit => a.price - a.discount
    case a: Vegetable => a.discountConstrained
  }
  g
}
