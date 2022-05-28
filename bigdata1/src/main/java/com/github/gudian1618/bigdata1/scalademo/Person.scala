package com.github.gudian1618.bigdata1.scalademo

/**
 * @author gudian1618
 * @date 2022/4/17 12:27
 * @version v1.0
 *          scala同java通过class来定义一个类
 *          scala的类可以拥有成员变量和成员方法
 *          定义成员变量时,必须赋值初始值,用于推断变量类型
 *          scala支持重写重载,同java一样,extends关键字
 *
 */
class Person(n: String, a: Int) {

  var name = n
  var age = a

  def say() = {
    println("hello world")
  }

}

object Person {
  def speak() = {
    println("hello world")
  }
}
