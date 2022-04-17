/**
 * @author gudian1618
 * @date 2022/4/17 12:26
 * @version v1.0
 *          scala的函数分类
 *          1.成员函数:定义在类内部的函数
 *          2.本地函数:定义在函数内的函数
 *          3.匿名函数:没有函数名,方法体的{}连接符是=>,作用:匿名函数可以作为参数进行赋值;把匿名函数作为参数进行传递
 *          4.高阶函数:把函数当做参数传递
 */

object Demo07 {

  def f1(a: Int, b: Int) = {
    a + b
  }

  // 当做参数进行赋值
  val f2 = (a: Int, b: Int) => {
    a + b
  }

  f2(2, 3)

  // 把匿名函数当做参数进行传递,f3是一个高阶函数
  def f3(a: Int, b: Int, f: (Int, Int) => Int) = {
    f(a, b)
  }

  f3(2,3,(a: Int, b: Int)=>{a+b})
  f3(2,3,(a: Int, b: Int)=>{a-b})
  f3(2,3,(a: Int, b: Int)=>{a*b})

  //

  def f4(a: String, b: String,f:(String,String)=>String) = {
    f(a,b)
  }

  f4("hello","world",(a:String,b:String)=>{a+b})

  def f5(a: String, b: Int,f:(String,Int)=>String) = {
    f(a,b)
  }

  f5("hello",2,(a: String,b: Int)=>(a*b))

  def f6(a: Int, b: Int,f:(Int, Int) => Unit) = {
    f(a,b)
  }

  f6(1,5,(a: Int, b: Int)=>{for (i<-a.to(b))println(i)})

  def f7(a:String,f:(String)=>Array[String]) ={
    f(a)
  }

  f7("hello.txt",(a:String)=>{a.split("\\.")})



}
