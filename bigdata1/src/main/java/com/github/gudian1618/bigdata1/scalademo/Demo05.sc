object Demo05 {

  val v1 = 100

  // 做显式的类型转换,形式固定,to指定类型
  val v2: String = v1.toString()

  // 隐式类型转换
  // 定义一个隐式的转换函数
  implicit def f1(x: Int) = (x.toString())

  val v3: String = v1

  implicit class AuthMethod(x: String) {
    def suffix() = {
      x.split("\\.").last
    }

    def prefix() = {
      x.split("\\.").head
    }
  }

  // 实现操作字符串,调用suffix()提取后缀
  "hello.txt".suffix()

  "hello.zip".prefix()


  // 隐式参数(隐式对象)                                                   
  // 泛型[]
  trait Adder[T] {
    def add(x:T,y:T):T
  }

  def f2(x:Int,y:Int)(implicit adder:Adder[Int])={
    adder.add(x,y)
  }

  f2(2,3)(new Adder[Int]{
    override def add(x:Int,y:Int)=x+y
  })

  implicit val a = new Adder[Int]{
    override def add(x: Int, y: Int) = x+y
  }

  f2(2,3)(a)
  f2(2,3)

}
