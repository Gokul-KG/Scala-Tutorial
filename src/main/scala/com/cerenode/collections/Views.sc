val k = 1 to 10000000

//val s = k.map(_ + 2)

val s = k.view.map(_ + 2)

val v = s.filter(_ % 100001 == 0)

v.foreach(println(_))


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
