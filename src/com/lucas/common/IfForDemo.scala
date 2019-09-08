package com.lucas.common

object IfForDemo {

  case class Book(title: String, authors: List[String])

  def main(args: Array[String]): Unit = {


    val books: List[Book] = List(
      Book("Structure and Interpretation", List("Abelson", "Harold", "Sussman")),
      Book("Principles of Compiler Design", List("Aho", "Alfred", "Ullman", "Jeffrey")),
      Book("Programming in Modula-a", List("Wirth,Niklaus")),
      Book("Introduction to Functional Programming", List("Bird", "Richard")),
      Book("The Java Language Specification", List("Gosling,James", "Joy,Bill", "Steele Guy", "Bracha,Gilad")))

    // for循环遍历每本书下的所有的作者，查询以Gosling的书，返回该书的标题
    var result = for (b <- books; a <- b.authors if a.startsWith("Gosling")) yield b.title
    // 执行结果：List(The Java Language Specification)
    println(result)

    // for循环遍历每本书所有的题标中包含Programming字符
    var result2 = for (book <- books; if book.title.indexOf("Programming") >= 0) yield book.title
    // 执行结果：List(Introduction to Functional Programming)
    println(result2)
  }
}
