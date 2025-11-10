package replace

import scala.annotation.tailrec

object DPK11_06 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    var index = 0
    while (index <= input.length - toReplace.length) {
      if (input.substring(index, index + toReplace.length) == toReplace) {
        return input.substring(0, index) + newToken + replace(input.substring(index + toReplace.length), toReplace, newToken)
      }
      index += 1
    }
    input

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

