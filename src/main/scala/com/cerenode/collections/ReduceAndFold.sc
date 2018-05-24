val s = List.range(1, 100)

val g = s.sum   // g.reduce(_ + _)

val k = s.take(10).product  //s.take(10).fold(0)(_ + _)

val t = s.reduce(_ + _)

val t1 = s.reduce { (cur, sum) =>
  sum + cur
}

val kl = s.take(10).fold(10) { (acc, cur) =>
  acc + cur
}

val jk = s.take(10).foldLeft(10) { (acc, cur) =>
  acc + cur
}
