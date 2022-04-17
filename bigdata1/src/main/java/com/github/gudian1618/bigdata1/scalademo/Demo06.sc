/**
 * @author gudian1618
 * @date 2022/4/17 11:44
 * @version v1.0
 *          scala的函数
 *          还会将方法体的最后一行代码作为结果返回,不需要家return关键字
 *          scala会根据函数的返回值自动推断出函数的返回值类型
 *          如果定义函数,{}没有=,则函数一律为Unit空,定义函数时,最好都带上=
 *          scala支持默认参数机制,调用时可覆盖
 *          scala支持变长参数机制,变长参数必需位于参数列表最后
 */

object Demo06 {
  println(" welcome to the Scala worksheet")

  def f1(a: Int, b: Int) = {
    a + b
  }

  def f2(a: String, b: Int) = {
    a * b
  }

  f1(2, 3)
  f2("hello", 2)

  // 接收一个字符串(文件名),函数最终返回文件名的后缀
  def f4(fileName: String) = {
    fileName.split("\\.")(1)
  }

  f4("fsdfsd1.zip")

  //
  def f5(a: Int, b: Int) = {
    a + b
  }

  def f6(a: Int, b: Int) {
    a + b
  }

  // 接收一个整数,打印0-n的所有数字
  def f7(n: Int) = {
    for (i <- 0.to(n)) {
      println(i)
    }
  }

  f7(5)

  def f8(a: Int, b: Int=10) = {
    a+b
  }

  f8(2)

  def f9(a: String*)={
    for(i<-a) {
      println(i)
    }
  }

  f9("hello","fdsf")

}
