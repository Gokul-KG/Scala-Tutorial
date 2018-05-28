// extends Ordered with for Rational Class

class Rational(var x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y) // g will hold the GCD of the numerator and the denominator

  def this(x: Int) = this(x, 1)

  val numer = x / g
  val denom = y / g



  override def toString: String = {
    numer + "/" + denom
  }

}



// create an ordering numer

