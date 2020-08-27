package com.lucas.common

import java.io.{FileNotFoundException, FileReader, IOException}

import scala.io.Source


object ExceptionDemo {

  // git git git git hit
  def main(args: Array[String]): Unit = {
    try {
      val f = Source.fromFile("resources/2.txt", "UTF-8")
      f.getLines().foreach(x => println(x))
    } catch {
      case e: FileNotFoundException => println("make sure the file exists in the path")
      case e: IOException => println("read file failed,check the net")
    } finally {
      println("exit finally...")
    }

  }
}
