import scala.annotation.tailrec
// class exercise

// HIGHER ORDER FUNCTION

def factorial_N(number: Int): Int = {
  def factorial_T(accumulator: Int, number: Int): Int = {
    if (number == 1)
      accumulator
    else
      factorial_T(accumulator * number, number - 1)
  }

  factorial_T(1, number)
}

// sum of integers example

// create 3 functions to calculate
//    - sum of integers (1 + 2 + 3 + 4 + ... )
//    - sum of cubes of integers (1^3 + 2^3 + 3^3 + ...)
//    - sum of factorials (1! + 2! + 3! + ...)

def sumN(a: Int, b: Int): Int = {
  @tailrec
  def sum(a: Int, b: Int, acc: Int = 0): Int = {
    if (a > b) acc
    else sum(a + 1, b, acc + a)
  }
  sum(a, b)
}

def sumOfCubes(a: Int, b: Int, acc: Int): Int = {
  if(a > b) acc
  else sumOfCubes(a + 1, b, acc + a * a * a)
}

def sumOfFactorials(a: Int, b: Int): Int = {
  if(a > b) 0
  else factorial_N(a) + sumOfFactorials(a + 1, b)
}


// write generic function for this

def genericSum(a: Int, b: Int, f: Int => Int): Int = {
  if(a > b) 0
  else f(a) + genericSum(a + 1, b, f)
}

genericSum(2, 4, (x:Int) => x)

genericSum(2, 4, (x: Int) => x * x * x)

genericSum(2, 4, factorial_N)

// CURRYING

def isDivisibleBy(k: Int, i: Int): Boolean = {
  println("evaluating isDivisibleBy")
  i % k == 0
}

isDivisibleBy(2, 11)
isDivisibleBy(2, 24)

/* -------------------------------------------------------------------  */

// HOMEWORK

// Q1

// vat is constant in a country = 8%
// service charge is constant in a store = 12%
// write function to get finalPrice

// abstract method of finding price of product across the world

def finalPrice(vat: Double,
               serviceCharge: Double,
               productPrice: Double): Double =
  productPrice + productPrice * serviceCharge/100 + productPrice * vat/100

// write curried function for the above given function

/* -------------------------------------------------------------------  */

// write tail recursive functions to all recursive given above
// sum, sumOfCubes, sumOfFactorials

/* -------------------------------------------------------------------  */

// write tail recursive function to generate nth Fibonacci number

