trait Box[T] {
  def value: T

}


case class IntBox(value: Int) extends Box[Int] {
  def +(other: IntBox) = value + other.value
}

case class LongBox(value: Long) extends Box[Long] {
  def +(other: LongBox) = value + other.value
}




val a = IntBox(3)

val b = IntBox(4)

val c = LongBox(10l)

implicit def intToIntBox(x:Int) = IntBox(x)
implicit def LongBox(x:IntBox) = LongBox(x.value)

a + b

a + 6

a + c