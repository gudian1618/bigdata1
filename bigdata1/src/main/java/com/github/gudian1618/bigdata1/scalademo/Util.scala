package com.github.gudian1618.bigdata1.scalademo

object Util {

  var food = ""

  def cook() = {
    println("cook food")
  }

  def main(args: Array[String]) = {
    val a1 = Array(1,2,3,4)
    for (i <- a1) {
      println(i)
    }
  }
}
