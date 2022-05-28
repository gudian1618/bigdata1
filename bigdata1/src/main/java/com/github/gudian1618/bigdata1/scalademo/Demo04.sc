import com.github.gudian1618.bigdata1.scalademo._

object Demo04 {

  println("hello world")

  var p1 = new Person("tom", 23)

  p1.say()

  Util.cook()
  Person.speak()

  val item1 = Item("huawei", 2999.99)
  val item2 = Item
  println(item1)

  val v1 = 100

  lazy val v2 = 200

  println(v2)

  // lazy 只能修饰常量,不能修饰变量
//  lazy var v3 = 300

  def f1(a:Int,b: Int) = {
    if (b!=0) {
      Some(a/b)
    } else {None}
  }

  f1(4,2)
  f1(4,2).getOrElse(0)
  f1(4,0)

}
