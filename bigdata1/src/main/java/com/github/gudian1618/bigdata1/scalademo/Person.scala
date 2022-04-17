package com.github.gudian1618.bigdata1.scalademo

/**
 * @author gudian1618
 * @date 2022/4/17 12:27
 * @version v1.0
 */

class Person {

  // 成员函数
  def eat()={
    println("吃食物")

    // 本地函数
    def cook() ={
      println("做饭")
    }
  }
}
