/**
 * 1.scala的异常处理机制痛java,只不过形式上有区别,在catch是通过case来匹配异常然后进行处理
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

}
