object Demo10 {

  // 声明定长Set
  val s1 = Set(1,1,2,2,3,3,4,4)

  val s2 = scala.collection.mutable.Set(1,2,3,4)

  val m1 = Map("tom"->23, "rose"->18,"jim"->25)

  val m2 = scala.collection.mutable.Map("tom"->23, "rose"->20)

  m2 += ("jim"->23,"andy"->30)

  m1.apply("tom")
  m1("tom")
  m1.get("wrwrewr").getOrElse(0)
  m1.keys

  val r1 = m1.filter{case(k,v) => v>20}

  val r2 = m1.map{case(k,v) =>(k,v+10)}
  val r3 = m1.mapValues{v=>v+10}

  val t1 = (1,2,"hello", 3,5)
  t1._3
  val t2 = (1,2,(3,4))
  t2._3._2
  val t3 = (1,(2,3),(4,Array(5,6)))
  t3._3._2(0)

  val m3 = Map("tom"->23, "rose"->18,"jim"->25)
  m3.filter{case(k,v)=>v>20}
  m3.filter{x=>x._2>20}
  m3.map{case(k,v)=>(k,v+10)}
  m3.map{x=>(x._1,x._2+10)}


}
