// methods and function syntax difference

def add2(a: Int): Int = {
  val t = a + 2
  t
}

val triple = (x: Int) => 3 * x: Int

val sum = (a:Int , b:Short) => a + b: Int

val sum2: (Int, Short) => Int = (a, b) => a + b

// anonymous function
{
  s: String => { "Hello " + s }
}

// difference between method and function

// 1
val t = add2(3)

val g = triple

// 2

def returnOne = 1

val return1 = () => 1: Int

// 3

def findSum(f: Int => Int): Int = {
  f(3) + f(3)
}

findSum(triple)


// 4


// method to function

val add2Fun = add2 _


def ui(i: Int): Boolean = i % 2 == 0

// return functions from a method

def isDivisibleBy(k: Int): Int => Boolean = {
  println("evaluating isDivisibleBy")
  i: Int => i % k == 0                       //  what is this ??
//  ui _
}

isDivisibleBy(2)(11)
isDivisibleBy(2)(24)

val isEven2 = isDivisibleBy(2)

def isEven3(x: Int): Boolean = isDivisibleBy(2)(x)

isEven2(11)
isEven2(12)
val kil = isEven3(11)
val ty = isEven3(22)






// impure function

var x = 0

def f(i: Int): Int = {
  x = x + 1
  i + x
}

f(1)

f(1)
