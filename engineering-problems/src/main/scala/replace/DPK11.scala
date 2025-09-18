package replace

object DPK11 {


  private def replace(input: String, toReplace: String, newToken: String): String = {
    if (toReplace.isEmpty) return input
    val result = new StringBuilder
    var i = 0
    while (i < input.length) {
      if (input.substring(i).startsWith(toReplace)) {
        result.append(newToken)
        i += toReplace.length
      } else {
        result.append(input.charAt(i))
        i += 1
      }
    }
    result.toString()
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
