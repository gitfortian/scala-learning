package com.lucas.common


import scala.io.Source

object FileOperator {
  def main(args: Array[String]): Unit = {

    val file = Source.fromFile("D:\\scala-learning\\resources\\2.txt")
    for (line <- file.getLines()) {
      println(line)
    }

    //    val file2 = Source.fromURI("")
    //    var webFile = Source.fromURL("http://scala.lang.org/")

  }
}
