package replace

import scala.annotation.tailrec

object DPK11_05 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    input.filter(_ => true).map { char =>
      val currentChar = char.toString
      if (currentChar == toReplace) newToken
      else currentChar
    }.mkString("")

  }

  def main(args: Array[String]): Unit = {
    val input = "Hello,World,How,Are,You"
    val toReplace = ","
    val newToken = "-"
    val result = replace(input, toReplace, newToken)
    println(s"Original: $input")
    println(s"Modified: $result")
  }

}

