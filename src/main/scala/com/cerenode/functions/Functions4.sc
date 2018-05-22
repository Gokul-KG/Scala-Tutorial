import scala.annotation.tailrec
// compose andThen

val double = (x:Int) => x + x
val square = (y:Int) => y * y
double compose square apply 2  // returns 8
double andThen square apply 2  // returns 16

// recursion

def factorial(number: Int): Int = {
  if (number == 1)
    1
  else
    number * factorial(number - 1)
}

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

factorial(5)
factorial_T(1, 5)
factorial_N(5)

// partial functions

val squareRoot: PartialFunction[Double, Double] = {
  case x if x >= 0 => Math.sqrt(x)
}
squareRoot.isDefinedAt(4)   // returns true
squareRoot.isDefinedAt(-4)  // returns false


// partially applied functions

def isInRange(left: Int, n: Int, right: Int): Boolean = {
  if (left < n && n < right) true else false
}

def is5InRange = isInRange(_: Int, 5, _: Int)

is5InRange(0, 8)

def between0and10 = isInRange(0, _: Int, 10)

between0and10(5)

between0and10(100)