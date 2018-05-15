val iter: Iterable[Int] = Iterable(1, 2, 3, 4, 5)

iter.foreach(println(_))

iter foreach println

iter.size

val s = iter.iterator

s.foreach(println(_))

s.foreach(println(_))

iter.grouped(2).foreach(println(_))

iter.sliding(2).foreach(println(_))

val iter2 = Iterable(4, 5, 6, 7, 8, 9, 10, 11)

iter zip iter2

iter zipAll(iter2, 9, 8)

iter.zipWithIndex

