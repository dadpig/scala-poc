package replace

object DPK11_09 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    input.foldLeft("") { (initVal, nextVal) =>
      if (nextVal.toString == toReplace) {
        initVal + newToken
      } else {
        initVal + nextVal.toString
      }
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
