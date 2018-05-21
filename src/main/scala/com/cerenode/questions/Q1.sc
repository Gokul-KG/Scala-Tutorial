
// Q1

var x = 0

val t = 9

if(t < 10)
  x = 1
else
  x = -1

println(x)

// Ans

val y = if (t<10) 1 else -1


// Q2
// iterate over list and remove duplicates and preserve the order

var outList: List[Int] = List()

val inList: List[Int] = List(1, 5, 9, 4, 4, 6, 2, 4, 1, 1, 4, 3)

inList.foreach { el =>
  if(!outList.contains(el))
    outList = outList :+ el
}

outList

// Ans

val g: List[Int] = inList.foldLeft(List.empty[Int]) { (acc, cur) =>
  if(acc.contains(cur))
    acc
  else
    acc :+ cur
}

// Q3

def isEven(i: Int) = {
  if (i % 2 == 0)
    Some(i)
  else
    None
}

isEven(2)
isEven(3)

def filterOut(l: List[Int]) = {
  l.flatMap { el =>
    isEven(el)
  }
}


val g2 = filterOut(List(1, 2, 3, 4))

// Ans

// Q4

// how would you store messages in a stream processor

// Ans

// Q5

val l: List[Int] = List(89, 5, 56, 9, 24, 46, 89, 124, 345, 67, 90)

def someOperation(l: List[Int]): List[Int] = {
  List()
}

// Ans

// Q6

// write a method to check whether a number is prime or not

def isPrime(i: Int): Boolean = 2 until i forall(k => i % k != 0)

// Q7
/*

this code is not working

val k = 1 to 10000000

val s = k.filter(isPrime(_))

val v = s.take(20)

v.foreach(println(_))
*/

// Ans

val k = 1 to 10000000

val s = k.view.filter(isPrime)

val v = s.take(20)

v.foreach(println(_))

// Q8

val listSet: List[Range] = List(
  99804 to 84563 by -1, 2567 to 8904, 9085 to 7657 by -1,
  43567 to 39458 by -1)


val maxList = {
  val t1 = System.nanoTime()
  val h = listSet.map { s =>
    s.filter(isPrime).min
  }
  val t2 = System.nanoTime()
  println("execution time :" + (t2 - t1))
  h
}


maxList


// Ans

val maxList2 = {
  val t1 = System.nanoTime()
  val h = listSet.map { s =>
    s.par.filter(isPrime).min
  }
  val t2 = System.nanoTime()
  println("execution time :" + (t2 - t1))
  h
}

maxList2

/*

store fruits and vegetables available in a store (no addition to this set)

store price of each item assuming price won't change

store stock of each item (shouldn't be -ve)

store a transaction (customerId, itemsPurchased)

functions

  return items bought by a customer

  return best selling item

  return total revenue

  return statistics of the items sold by category and by item

  generate a bill

 */