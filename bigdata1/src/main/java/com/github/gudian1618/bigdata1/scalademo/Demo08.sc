/**
 * @author gudian1618
 * @date 2022/4/17 20:03
 * @version v1.0
 */

object Demo08 {

  for (i <- 1.to(11)) {
    println(11 - i)
  }

  for (i <- 0.to(10).reverse) {
    println(i)
  }

  for (i <- 10.to(0, -1)) {
    println(i)
  }

  def countdown(n: Int) = {
    for (i <- 0.to(n).reverse) {
      println(i)
    }
  }

  countdown(10)

  val a1 = Array(1, 2, 3, 4, 5, 6)

  def revert(arr: Array[Int]) = {
    for (i <- 0.until(arr.length - 1, 2)) {
      val t = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = t
    }
  }

  revert(a1)
  a1

  var m1 = Map("book" -> 10, "gun" -> 100, "ipad" -> 1000)

  for ((k, v) <- m1) yield {
    (k, v * 0.9)
  }
}
