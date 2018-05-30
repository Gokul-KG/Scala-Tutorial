package com.cerenode.fruitstore

import scala.io.Source

object Main extends App {
  // Name, Price, Stock
  val f = Source.fromFile("<path-to-file>").getLines()
  val fruitList = f.map { line =>
    val ls = line.split(",")
    new Fruits(ls(0), ls(1).toFloat, ls(2).toInt)
  }.toList

  val veg = Source.fromFile("<path-to-file>").getLines()
  val vegList = veg.map { line =>
    val ls = line.split(",")
    new Vegetables(ls(0), ls(1).toFloat, ls(2).toInt)
  }.toList

  // itemcode, qty, total, custId, transId, type
  val trans = Source.fromFile("<path-to-file>").getLines()
  val transList = trans.map { line =>
    val ls = lineSplit(line)
    Transaction(ls(0), ls(1), ls(2).toInt, ls(3).toFloat, ls(4), ls(5))
  }.toList

  def getItemsForCust(custId: String): List[String] = {
    val g = transList.filter(p => p.custId == custId)
    g.map(_.itemCode)
  }
}













