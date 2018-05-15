val k = 1 to 10000000

//val s = k.map(_ + 2)

val s = k.view.map(_ + 2)

val v = s.filter(_ % 100001 == 0)

v.foreach(println(_))
