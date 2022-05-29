/**
 *  1.scala的集合类型包括: Array List Set Map Tuple Range Iterator
 *  2.scala的Array分位定长和变长 定长:immutable 变长:mutable
 *  3.scala的下标从0开始
 */

object Demo09 {

  // 创建一个定长数组,并赋值初值
  val a1 = Array(1, 2, 3, 4)

  val a2 = new Array[Int](3)

  // 创建一个变长数组
  val a3 = scala.collection.mutable.ArrayBuffer(2,5,1,7,8,10)

  a1.apply(0)
  a1(0)
  a1(0)=10
  a1
  a3.append(5)
  a3

  a3.max
  a3.min
  a3.sum
  a3.length
  a3.reverse
  a3.take(2)
  a3.takeRight(2)
  a3.drop(2)
  a3.dropRight(2)
  a3.head
  a3.last

  // 找出后4项的平均值
  a3.takeRight(4).sum/4

  // 找出中间项的极差
  val a4 = a3.drop(1).dropRight(1)
  val a5= a4.max - a4.min

  val a6= Array(1,2,3)
  val a7= Array(3,4,5)

  // 交集
  a6.intersect(a7)
  // 并集
  a6.union(a7).distinct
  a6.diff(a7)
  a7.diff(a6)

  val l1 = List(1,2,3,4)
  val l2 = scala.collection.mutable.ListBuffer(1,2,3,4)

  l1.apply(0)
  l1(0)

  val l3 = List(1,2,3,4,5,6,7,8,9)

  // filter方法根据指定的匿名函数实现过滤
  l3.filter{num=>num>4}

  l3.filter{num=>num>2&&num%2==0}
  l3.filter{num=>num%2==1}.sum

  val l4 = List("tom M 23","rose F 18","jary M 30","jim F 35")

  l4.filter{line=>line.contains("M")}
  l4.filter{line=>line.split(" ")(1).equals("M")}

}
