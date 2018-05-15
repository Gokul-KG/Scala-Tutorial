import scala.collection.immutable.ListMap

val g: Map[Int, String] = Map(1 -> "a", 2 -> "b", 3 -> "c",
  4 -> "d", 5 -> "e", 6 -> "f", 7 -> "g", 8 -> "z")

g.apply(1)

g(1)

g.get(2)

g.get(11)

if(g.get(9).isDefined)
  println(9)
else
  println(None)

val h: Map[Int, String] = g + (9 -> "h")

val i = h ++ g

i.foreach { case (key, value) =>
    println(key + "->" + value)
}

i.keySet

val k = ListMap(1 -> "a", 2 -> "b", 3 -> "c",
  4 -> "d", 5 -> "e", 6 -> "f", 7 -> "g")
