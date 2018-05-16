val s = Set(1, 2, 3, 3)

s(0)

s.apply(0)

s(1)

val t = Set(3, 4, 5, 6)

val x = s -- t

val y = t -- s

val z = t - 6

val list = List(1, 2, 3)

val tx = list.flatMap { x =>
  val k = x * 3
  if(k < 5)
    Some(k)
  else
    None
}