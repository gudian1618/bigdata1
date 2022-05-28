package com.github.gudian1618.bigdata1.scalademo

abstract class Teacher {
  // 抽象方法
  def makeNote(info:String): String
  // 抽象方法
  def teach(): Unit
  // 普通方法
  def say()={
    println("hello world")
  }
}
