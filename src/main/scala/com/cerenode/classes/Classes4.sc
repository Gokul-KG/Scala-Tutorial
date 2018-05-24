import scala.io.Source

def matchTest(x: Int): String = {
  val ret = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "others"
  }
  ret
}

matchTest(1)
matchTest(2)
matchTest(3)

def matchTest2(x: Any): Any = x match {
  case 1 => "one"
  case "two" => 2
  case y: Int => "scala.Int " + y
  case y: String => {
    y
  }
  case _ => "something else"
}

matchTest2(1)
matchTest2(45.5f)
matchTest2(3)

object ListClass {
  private val ls = List(45, 65, 87, 32, 132, 10)

  def getIdxValue(idx: Int): Option[Int] = {
    if(idx < ls.length)
      Some(ls(idx))
    else
      None
  }
}


// sealed class

case class User(name: String, acc: Account)
trait Account
case class Paypal(email: String) extends Account
case class Card(number: Long) extends Account

def whatIs(obj: User): Unit = {
  val ret = obj match {
    case User(name, Paypal(email))  => (name, email)
    case User(name, Card(number)) => (name, number)
  }
  println(ret)
}

// @unchecked

def whatIs2(obj: User): Unit = {
  val ret = (obj) match {
    case User(name, Paypal(email)) => (name, email)
  }
  println(ret)
}

class A {
  val t = {
    val file = Source.fromFile("/Users/mithunrajarackal/test/orphaFiles/orphaWithEntrezProbeIdExpressionClean.csv")
    file.getLines().toList.head
  }
  def g = {
    val file = Source.fromFile("/Users/mithunrajarackal/test/orphaFiles/orphaWithEntrezProbeIdExpressionClean.csv")
    file.getLines().toList.head
  }
  lazy val kl =  {
    val file = Source.fromFile("/Users/mithunrajarackal/test/orphaFiles/orphaWithEntrezProbeIdExpressionClean.csv")
    file.getLines().toList.head
  }
}

val h = new A

h.t
h.g
h.kl

