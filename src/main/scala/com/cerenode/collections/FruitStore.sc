object FruitList extends Enumeration {
  val Orange,
  Apple,
  Grapes,
  Banana = Value
}

val priceMap: Map[FruitList.Value, Float] =
  Map(FruitList.Orange -> 13.4f,
    FruitList.Apple -> 45.6f,
    FruitList.Grapes -> 33.9f,
    FruitList.Banana -> 50f
  )

val fruitStock: Map[FruitList.Value, Int] =
  Map(FruitList.Orange -> 10,
    FruitList.Apple -> 20,
    FruitList.Grapes -> 15,
    FruitList.Banana -> 25
  )

val sales: Map[FruitList.Value, List[Int]] =
  Map(FruitList.Orange -> List(3, 3, 3, 1),
    FruitList.Apple -> List(1, 2, 1, 4, 3),
    FruitList.Grapes -> List(1, 1, 1, 2, 1),
    FruitList.Banana -> List(5, 6, 6)
  )

val stats = sales.keys.toVector.map { fruit =>
  val price = priceMap(fruit)
  val totalSales = sales(fruit).sum
  val remaining = fruitStock(fruit) - totalSales
  fruit -> (totalSales * price.toFloat, totalSales, remaining)
}.toMap

stats.foreach { case (fruit, stat) =>
  println(fruit + f"\t\t ${stat._1}%.2f" +
    "\t" + stat._2 + "\t" + stat._3)
}

val revenue = stats.map(_._2._2).sum

val lowSales = stats.find(_._2._3 < 5)

sales.values.toVector.flatten.sum




// Scala product of two vectors

val t = Vector(1.2f, 3.4f, 2.4f)

val u = Vector(2.3f, 3.4f, 10.9f)

t zip u map (xy => xy._1 * xy._2)



//find pairs of integers i and j where 1 <= j < i <= n and i + j is prime

val f = (1 to 20) flatMap { i =>
  (1 to i) map { j =>
    (i, j)
  }
}

f.foreach { pair =>
  val sum = pair._1 + pair._2
  val test = 2 to sum - 1 forall(k => sum % k != 0)
  if(test)
    print(pair + ", ")
}