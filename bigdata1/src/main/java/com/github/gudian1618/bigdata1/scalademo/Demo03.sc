import scala.language.postfixOps

object Demo03 {

  // 柯里化可以形成自建结构,调用结构层次更加清晰

  def f1(a: Int, b: Int) = {
    a + b
  }

  // 柯里化的表达式
  def fll(a: Int)(b: Int) = {
    a + b
  }

  f1(2, 3)
  fll(2)(3)

  def f2(a: Int, b: Int, c: Int) = {
    a + b + c
  }

  // 写出f2的等价的柯里化表达式
  def f21(a: Int)(b: Int)(c: Int) = {
    a + b + c
  }

  def f3(a: Int, b: Int, f: (Int, Int) => Int) = {
    f(a, b)
  }

  def f31(a: Int)(b: Int)(f: (Int, Int) => Int) = {
    f(a, b)
  }




}
