package com.github.gudian1618.bigdata1.scalademo

/**
 * 1.scala提供了一种样例类,通过case来定义
 * 2.必须显式的声明一个主构造器,底层会自动构造一个空辅助构造器
 * 3.case class 会自动混入序列化特质,相当于省略了实现序列化接口
 * 4.case class 会默认重写类的toString方法,便于测试
 * 5.case class 不需要new,就可以创建类对象
 * 6.后续开发spark程序,封装bean习惯上使用case class 来封装
 */

case class Item(title: String, Price: Double) {

}
