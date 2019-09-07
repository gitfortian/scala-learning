package com.lucas.common

import scala.collection.mutable.ListBuffer

object RegexDemo {

  def main(args: Array[String]): Unit = {

    val regex = """^a\w+?e$""".r

    val str = "anede"

    regex.findAllIn(str).foreach(println(_))

    val pattern = """([0-9]{1,5}) ([a-z]+)""".r

    "321 nsj" match {

      case pattern(num, item) => println(num + ":" + item)
      case _ => println("not matched")

    }

    val list = List(1, 2, 3)

    val list2 = List("1", "2", 3)

    println(list.head)
    println(list.tail)

    val lists = list :: list2 //将list作为新的list的head，list2作为tail生成新的list
    println(lists)

    val lists2 = list ::: list2 //将list和list2连接起来组成新的list
    println(lists2.init)
    println(lists2.zipWithIndex)
    println(lists2.indices zip lists2)
    println(lists2.mkString("and"))
    println(lists2.mkString("[", ",", "]"))

    println(lists2.toArray)

    //    while (list.iterator.hasNext) {
    //      println(list.iterator.next())
    //    }
    /*    for (i <- list.indices) {
          println(list.applyOrElse(i, "zz")) //不明白为什么会有OrElse方法，什么情况下需要有默认值
        }*/
    val listn = List("hadoop", "flink", "spark")
    listn.map(_.length())

    println(listn.flatMap(_.toList.mkString("==")))

    val n = List.range(1, 10).filter(_ % 2 == 0)

    val x = n.find(_ > 5)
    println(x.get)

    n.dropWhile(_ < 10) //删除符合条件的

    n.takeWhile(_ > 3) //取出list中符合条件的作为新的list返回

    println(List(2, 4, 6, 8, 10).span(x => x <= 8))

    println(List(1, -2, 4, 3, 10, -39).sortWith(_ > _))
    println(List(1, -2, 4, 3, 10, -39).sortWith(_ < _))

    val listbuf = ListBuffer[Int]()
    listbuf += 13
    listbuf += 2
    listbuf ++= List(1, 2, 3)
    println((listbuf.indices zip listbuf.sortWith(_ > _)).unzip)


  }
}
