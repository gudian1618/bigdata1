/**
 * @author gudian1618
 * @date 2022/4/17 21:14
 * @version v1.0
 *          如何编写scala的递归函数
 *          scala中递归函数的返回值类型必须显式的声明,不能使用自动推断
 *          递归函数结束条件的返回值,必须加 return 关键字返回
 */

object Demo02 {
  // 给定一个斐波那契数列
  // 写递归函数的技巧:
  // 1.找到结束条件
  // 2.找到项与项之间的函数关系,即递归通项式函数找到

  // 2 3 4 9 16 81 ...
  def f1(n: Int): Int = {
    if (n == 0) return 1
    if (n == 1) return 2
    else f1(n - 1) + f1(n - 2)
  }

  f1(0)
  f1(1)
  f1(5)
  f1(7)

  def f2(n: Int): Int = {
    if (n == 0) return 2
    if (n == 1) return 3
    else f2(n - 2) * f2(n - 2)
  }

  f2(4)

  // 2 3 4 9 8 27 16 81 ...
  def f3(n: Int): Int = {
    if (n == 0) return 2
    if (n == 1) return 3
    if (n % 2 == 0) 2 * f3(n - 2)
    else 3 * f3(n - 2)
  }

  f3(4)
  f3(7)

  def mi(x: Double, n: Int): Double = {
    if (n == 0) return 1
    else if (n > 0 && n % 2 == 0) mi(x, n / 2) * mi(x, n / 2)
    else if (n > 0 && n % 2 == 1) x * mi(x, n - 1)
    else 1 / mi(x, -n)
  }

  mi(2, -7)
  mi(2, 7)


}
