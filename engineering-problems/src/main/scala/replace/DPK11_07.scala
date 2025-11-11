package replace

object DPK11_07 {


  private def replace(input: String, toReplace: String, newToken: String): String = {
    var result = ""
    var i = 0
    while (i < input.length) {
      if (input.charAt(i) == toReplace.charAt(0)) {
        result += newToken
      } else {
        result += input.charAt(i)
      }
      i = i+1;
    }
    result
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

