class Rational(x: Int, y: Int) {

  def numer = x
  def denom = y

}


val x = new Rational(3, 4)

println(x)
x.numer
x.denom


def addRationals(a: Rational, b: Rational): Rational = {
  new Rational(a.numer * b.denom + a.denom * b.numer,
    a.denom * b.denom)
}
