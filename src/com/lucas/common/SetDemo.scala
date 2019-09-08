package com.lucas.common

import java.io.File

import scala.collection.immutable.{SortedMap, TreeMap, TreeSet}
import scala.io.Source
import scala.reflect.ClassTag

object SetDemo {
  def main(args: Array[String]): Unit = {

    val data = scala.collection.mutable.Set.empty[Int] //可变Set

    data ++= List(1, 2, 3, 4)
    data += 1

    println(data)

    val dMap = scala.collection.mutable.Map.empty[String, String]
    //集合中操作集合元素的时候使用 ++=  --=  操作普通元素的时候 += -=
    dMap("hadoop") = "hdfs" //Map中直接使用key=value的方式添加元素
    println(dMap)
    //有序的Set TreeSet 有序的Map  SortedMap TreeMap
    val treeSet = TreeSet(12, 3, 4, 32, 46, 7, 43, 7, 31)
    println(treeSet)
    //目前感觉sortedMap 和 TreeMap是一样的，还不清楚区别
    val sortedMap = SortedMap("Hadoop" -> "Java", "Spark" -> "Scala", "Flink" -> "Both")
    println(sortedMap)

    val treeMap = TreeMap("Hadoop" -> "Java", "Spark" -> "Scala", "Flink" -> "Both").zipWithIndex
    println(treeMap)

    println(bigger("c", "h"))


  }

  //泛型使用  之前遇到过不会用，跟java还是不太一样的，编译时无法确定，在运行时确定
  def testT[T: ClassTag](elem: T): Unit = {
    println(elem)
  }

  // A =:=B // 表示A类型等同于B类型
  // A <:<B	// 表示A类型是B类型的子类
  def rocky[T](i: T)(implicit ev: T <:< java.io.Serializable) {
    // 执行结果：Life is short ,you need spark!!!
    println("Life is short ,you need spark!!!")
  }

  def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T]) =
  // 比较大小，返回较大的值
    if (ordered(a) > b) a else b

  //隐式转换用法之一：增强函数功能  在指定类下调用对应的方法发现没有，就会默认去相同参数的隐式函数(implicit关键字作用在方法前面的方法)

}

class RicherFile(var file: File) {
  def read = Source.fromFile(file).mkString;
}

/*
 * 伴生类 class FileImplicits
 * 伴生对象 object FileImplicits
 * 伴生对象可以调用伴生类中的任意对象
 */
//通过implicit def file2RicherFile(file: File) = new RicherFile(file)可以使用FileImplicits(path).read方法，其实调用的是RicherFile的read方法
class FileImplicits(path: String) extends File(path)

object FileImplicits {

  implicit def file2RicherFile(file: File) = new RicherFile(file); // File -> RicherFile

}


object ImplicitsInternals {
  def main(args: Array[String]): Unit = {
    /*
     * new FileImplicits对象，在FileImplicits伴生对象或者伴生类找不到read方法，
     * 则会在找参数相同的隐式方法(implicit关键字作用在方法前面的方法)，
     * 在file2RicherFile方法中完成了类型隐式转换 File -> RicherFile
     * 调用在RicherFile类中的read方法。
     *
     * 执行结果：
     * I feel Great!!!
     * I am so happy to be here!!!
     */
    println(new FileImplicits("E:\\input.txt").read)
  }
}