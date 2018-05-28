
case class Person(name: String, age:Int, height:Float) extends Ordered[Person] {
  override def compare(that: Person): Int = {

    -(this.age - that.age)

  }
}



val p1 = Person("P1", 22, 5.6f)
val p2 = Person("P2", 50, 5.2f)
val p3 = Person("P3", 20, 6f)


p1 compare  p2
p1 > p2






