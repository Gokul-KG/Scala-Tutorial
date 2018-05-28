import scala.util.Sorting
case class Person( name:String, age:Int)

object ageOrdering extends Ordering[Person] {
  override def compare(x: Person, y: Person): Int = (x.age - y.age)
}

object nameOrdering extends Ordering[Person] {
  override def compare(x: Person, y: Person): Int = (x.name.length - y.name.length)
}



val persons = (for {
  age <- 1 to 26
} yield Person("name_"+ age, age)).toList


