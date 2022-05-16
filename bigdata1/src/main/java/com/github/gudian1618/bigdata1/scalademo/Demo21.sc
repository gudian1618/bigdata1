object Demo21 {

  println(f1("hello"))//将打印:[hello]

  def f1(a: String, b: String = "[", c: String = "]") = b + a + c



}
