// auxilliary constructors

class Person(firstName: String, lastName: String, age: Int){

  def this(name: String) { // An auxiliary constructor
    this(name, "", 0) // Calls primary constructor
    println("No last name or age given")
  }

  def this(name: String, age: Int) { // Another auxiliary constructor
    this(name, "", age)
    println("No last name given")
  }

  def this(name: String, lastName: String) {
    this(name, lastName, 0)
    println("No age given")
  }
}

val a = new Person("Fred", "Nicholas", 34)
val b = new Person("Fred")
val c = new Person("Fred", "Nick")


// case classes

case class Car(name: String, price: Float, make: String, engine: Int,
               fuel: String)

val g = Car("City", 30000f, "Honda", 1393, "Petrol")

g.price

val f = g.copy(price = 32000f, engine = 1245, fuel = "Diesel")


// abstract class

abstract class Student(a: Int) {
  val next: String
  def methodX: String
}

trait Student2 {
  val next: String
  def methodX: String
}







