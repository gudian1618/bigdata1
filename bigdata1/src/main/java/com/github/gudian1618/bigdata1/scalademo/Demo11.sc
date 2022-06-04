object Demo11 {

  val l1 = List(("bj", 12000), ("sh", 8000), ("bj", 9200), ("sh", 13000))

  val r1 = l1.filter(x => x._1.equals("bj"))
  val r2 = l1.filter { x => x._1.equals("sh") }.map(x => x._2).sum / 2

  val r3 = l1.groupBy { x => x._1 }

  val l2 = List("hello world", "hello scala", "hello spark")

  val r4 = l2.map(line => line.split(" "))

  // 扁平化映射,一般用于读取文件后,处理每行数据,获取行中的单个数据
  val r5 = l2.flatMap{ line => line.split(" ")}

  // 统计l2中的单词出现的频度,比如返回的结果(hello,3)
  val r6 = l2.flatMap{ line => line.split(" ")}.groupBy{ word => word }.map{case (k,v) =>(k,v.length)}

//  val r7 = l2.flatMap{ line => line.split(" ")}.groupBy{ word => word }.mapValues{ v=>v.length}


}
