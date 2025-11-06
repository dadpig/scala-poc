package replace

object DPK11_03 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    input.foldLeft("") { (acc, char) =>
      val currentChar = char.toString
      if (currentChar == toReplace) acc + newToken
      else acc + currentChar
    }

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

