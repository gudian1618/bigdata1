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
  val a3 = scala.collection.mutable.ArrayBuffer(1,2,3,4)

  a1.apply(0)
  a1(0)
  a1(0)=10
  a1
  a3.append(5)
  a3

}
