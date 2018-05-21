import scala.annotation.tailrec
// compose andThen

val double = (x:Int) => x + x
val square = (y:Int) => y * y
double compose square apply 2  // returns 8
double andThen square apply 2  // returns 16

// recursion

object Factorial {

  def factorial(number: Int): Int = {
    if (number == 1)
      1
    else
      number * factorial(number - 1)
  }

  //println(factorial(5))

  //factorial(5 * factorial(4 * factorial(3 * factorial(2 * 1))))

  @tailrec
  def factorial_T(accumulator: Int, number: Int): Int = {
    if (number == 1)
      accumulator
    else
      factorial_T(number * accumulator, number - 1)
  }


  def factorial_N(number: Int): Int = {
    @tailrec
    def factorial_T(accumulator: Int, number: Int): Int = {
      if (number == 1)
        accumulator
      else
        factorial_T(accumulator * number, number - 1)
    }

    factorial_T(1, number)
  }
}

Factorial.factorial_T(1, 2)
Factorial.factorial_N(2)

// partial functions

val squareRoot: PartialFunction[Double, Double] = {
  case x if x >= 0 => Math.sqrt(x)
}
squareRoot.isDefinedAt(4)   // returns true
squareRoot.isDefinedAt(-4)  // returns false
