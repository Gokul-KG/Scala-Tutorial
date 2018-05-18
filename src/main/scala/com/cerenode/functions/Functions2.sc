// function with default parameter

def product(a: Int, b: Int = 1): Int = a * b

product(12)

product(2, 3)



// pass function as an argument

val isOdd = (x: Int) => x % 2 != 0 : Boolean

val isEven = (x: Int) => x % 2 == 0 : Boolean

def y(list: List[Int], f: Int => Boolean): List[Int] = {
    list.flatMap { el =>
      if (f(el))
        Some(el)
      else
        None
    }
}

y(1 to 10 toList, isOdd)

y(1 to 10 toList, isEven)


// call by value vs call by name

def test(x: Int, y: Int) = x * x

def test2(x: => Int, y: Int) = x * x

test(3 + 4, 8)

test2(8, 3 + 4)

// example of using a call by name function

def time() = {
  println("Getting time in nano seconds")
  System.nanoTime
}

def delayed(t: => Long): Unit = {
  println("In delayed method")
  println("Param: " + t)
}

delayed(time())

delayed(time())


def twoTimes(t: => Long): (Long, Long) = {
  val y = t
  (y, y)
}

twoTimes(time())

def twoTimes2(t: => Long): (Long, Long) = {
  (t, t)
}

twoTimes2(time())
