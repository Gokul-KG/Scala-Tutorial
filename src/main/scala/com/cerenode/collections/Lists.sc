val r = 1 to 4

val r9 = 1 until 4 by 2
r9 foreach println

r.foreach(println(_))

val r2 = 't' until 'z'

r2 by 3 foreach println

val array: Array[Char] = Array('a', 'b', 'c', 'd')

array(0) = 'z'

array.foreach(println(_))

val p: Byte = 1

val pList = List(p, 'a', "asd")

pList.apply(2)

pList(2)

val cList = List(1, 2, 3, 4)

val dList = List(4, 5, 6, 7)

val cdList = cList ++ dList

val newCList = 0 :: cList

val newDList = dList :+ 8

val testList = newCList.padTo(9, 13)

val sortedList1 = testList.sorted

val sortedList2 = testList.sortBy(f => -f)


val l1: List[Int] = List.range(1, 10)

val l2: List[Char] = List.range('a', 'g', 2)
