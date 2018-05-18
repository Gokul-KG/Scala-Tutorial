//For loop Basic Example
for (i <-  List(1,2,3)) {
  println(i)
}

// here i <- List(1 , 2, 3) is called generator expression


// Loop over the numbers in a range.
for (i <- Range(5, 8)) {
  println("range1 " +  i)
}

// Loop with a step of 2.
for (i <- Range(0, 5, 2)) {
  println("range2 " + i)
}

// A decrement for-loop.
// ... Step is negative 1.
for (i <- Range(10, 5, -1)) {
  println("range3 " + i)
}





//Filtering Values


for (
  number <- 1 to 10
  if number % 2 == 0 && number % 4 == 0

) println(number)




for (
  number <- 1 to 10
  if number % 2 == 0
  if number % 4 == 0

) println(number)


//Yielding values

val even = for (
  number <- 1 to 10
  if number % 2 == 0

) yield number

//We can define variables inside for expressions.

val even2 = for {
  number <- 1 to 10
  if number % 2 == 0
  twice = number * 2

} yield twice


//multiple generators

val res = for {
  n <- 1 to 3
  c <- 'a' to 'c'

} yield n -> c


val newRes = for {
  n <- 1 to 10
  if n % 2 == 0
  c <- 'a' to 'c'
  b = n + c

} yield (n, c, b)


// when you have to use more expression to calculate the return value


val mapRes = for {
  n <- 1 to 3
  c <- 'a' to 'c'

} yield {
  s"""$n -> $c """
}
