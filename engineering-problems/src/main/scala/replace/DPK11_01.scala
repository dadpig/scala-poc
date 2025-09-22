package replace

object DPK11_01 {


  private def replace(input: String, toReplace: String, newToken: String): String = {
    if (toReplace.isEmpty) return input
    input.split(toReplace, -1).mkString(newToken)

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
