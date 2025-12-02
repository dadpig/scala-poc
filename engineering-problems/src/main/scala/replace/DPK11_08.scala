package replace

object DPK11_08 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    var result = ""
    input.map(c => {
      if (c == toReplace.charAt(0)) {
        result += newToken
      } else {
        result += c.toString
      }
    })
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
