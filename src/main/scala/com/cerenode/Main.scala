package com.cerenode

class Main {
  private val k = 7
  println("start " + Main.k)
}

object Main {
  private val k = 8

  def main(args: Array[String]): Unit = {
    val j = new Main
    println("hello World " + j.k)
  }

}
