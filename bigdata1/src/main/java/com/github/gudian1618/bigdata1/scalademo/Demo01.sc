/**
 * @author gudian1618
 * @date 2022/4/17 20:24
 * @version v1.0
 *          通用简化规则
 *          1.如果方法体只有一行代码,则方法体可以省略
 *          2.如果在调用scala一个方法时,方法的参数只有一个,则方法的.()可以省略
 *          3.关于匿名函数的化简: 如果匿名函数参数类型可以推断,则匿名函数的参数类型可以省略;  如果匿名函数的参数列表只有一个的话,则参数()可以省略
 *          4.终极化简: 可以通过_ 来代替参数
 */

object Demo01 {

  def f1(a: Int, b: Int) = a + b

  val s1 = "hello world"

  println(s1)

  s1.take(2)
  s1 take 2

  1.to(5)
  1 to 5

  //  生成区间并指定步长
  1 to 5 by 2

  def f2(a: Int, b: Int, f: (Int, Int) => Int) = {
    f(a, b)
  }

  f2(2, 3, (a, b) => a + b)
  f2(3, 4, (a, b) => a * b)

  def f3(a: String, f: (String) => String) = {
    f(a)
  }

  f3("hello", a => a * 2)

  f2(5, 6, _ + _)
  f2(5, 6, _ * _)

  f3("hello", _ * 2)

}
