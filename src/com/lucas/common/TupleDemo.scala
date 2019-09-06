package com.lucas.common

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object TupleDemo {
  def main(args: Array[String]): Unit = {
    val tuple = Tuple3(1, "2", 3L)
    //tuple 和list或者array 不同得地方是：元组不可变，可以容纳不同得数据类型，索引是从1开始
    println(tuple._3, tuple._2, tuple._1)

    val array = Array(1, 3, 4, 5, 6, 0)
    for (x <- array) {
      println(x)
    }

    val map = Map("hongloumeng" -> 12.0, "xiyouji" -> 20.0, "sanguoyanyi" -> 50.1, "shuihuzhuan" -> 10.0)

    for ((key, v) <- map) {
      println(key, v)
    }

    val number = new Array[Int](1)
    number(0) = 1
    val numberBuf = new ArrayBuffer[Int]()
    val numberBuf2 = new ArrayBuffer[Int]()
    numberBuf += 1 //数组追加元素 +=，追加数组使用++=

    numberBuf ++= number
    numberBuf ++= numberBuf2

    numberBuf.toArray //动态数组转为数组

    for (x <- numberBuf if x % 2 == 0) yield x * 2

    numberBuf.max
    val a = numberBuf.sorted.reverse
    val b = Sorting.quickSort(numberBuf.toArray)

    //数组就是将一类数据放在一个容器中，分为静态和动态数组，静态得初始化的时候需要指定array的大小，动态的不需要，会自动扩容


  }
}
