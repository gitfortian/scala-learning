package com.lucas.common

import scala.collection.SortedMap

object MapZipDemo {

  def main(args: Array[String]): Unit = {
    val m1 = scala.collection.immutable.Map("hadoop" -> 100, "flink" -> 300, "spark" -> 400)
    val m2 = scala.collection.mutable.Map("hadoop" -> 100, "flink" -> 300, "spark" -> 400)
    //Map分为可变和不可变的Map，可变的Map可以+= -=去添加删除元素  删除元素是通过对应的key删除
    //排序Map是根据key去排序
    val m3 = SortedMap("hadoop" -> 200, "flink" -> 100, "kafka" -> 300)
    for ((k, v) <- m3) {
      println(k + ">>>" + v)
    }
    m2 += ("druid" -> 350)
    m2 -= "spark"
    for ((k, v) <- m1) {
      println(k + "-->>" + v)
    }

    val list = for ((k, v) <- m1) yield v * 2

    for (l <- list) {
      println(l)
    }

    println("Spark FlinkDruid".partition(_.isLower))

    val arr1 = Array("flink", "spark", "hadoop")

    val arr2 = Array(1, 2, 3)

    arr1.zip(arr2).foreach(x => println(x))

  }

  class ApplyDemo() {

    def say(): Unit = {
      println("this is a apply test")
    }
  }

  object ApplyDemo {
    def apply(): ApplyDemo = new ApplyDemo
  }

  //不带new 的类()会默认调用半生对象的apply方法返回的是伴生类的伴生对象，直接访问伴生类的方法
  object MainDemo {
    def main(args: Array[String]): Unit = {
      val a = ApplyDemo()
      a.say()
    }
  }

}
