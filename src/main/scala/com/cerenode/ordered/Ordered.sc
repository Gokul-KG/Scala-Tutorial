
case class Person(name: String, age:Int) extends Ordered[Person] {
  override def compare(that: Person): Int = {

    -(this.age - that.age)

  }
}

val persons = (for {
  age <- 1 to 26
} yield Person("name_"+ age, age)).toList

println(persons)

val s = persons(0) > persons(1)




persons.sorted





