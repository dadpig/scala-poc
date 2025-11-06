package replace

import scala.annotation.tailrec

object DPK11_04 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    @tailrec
    def helper(index: Int, acc: String): String = {
      if (index >= input.length) acc
      else if (input.substring(index).startsWith(toReplace))
        helper(index + toReplace.length, acc + newToken)
      else
        helper(index + 1, acc + input.charAt(index).toString)
    }
    helper(0, "")
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

