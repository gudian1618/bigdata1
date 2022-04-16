/**
 * 1.scala的异常处理机制痛java,只不过形式上有区别,在catch是通过case来匹配异常然后进行处理
 * 2.match case 只要发现有一个匹配,则剩余case不会执行,直接跳出
 */

object Demo05 {
  println("Welcome to the Scala worksheet")

  try {
    throw new RuntimeException
  } catch {
    case e: NullPointerException => {
      println("null error")
    }
    case e: Exception => {
      println("other error")
    }
  } finally {
    println("end")
  }

  val num = 5
  val result = num match {
    case 5 => {
      println("555")
      "555"
    }
    case 6 => {
      println("666")
    }
    case 7 => {
      println("777")
    }
  }

  val s2 = 8
  s2 match{
    case x if x>=5=>{println("555")}
    case x if x>=6=>{println("666")}
    case x if x>=7=>{println("7777")}
  }

}
