package replace

object DPK11_02 {


  private def replace(input: String, toReplace: String, newToken: String): String = {

    def reduceString(s: String, func: (String, String) => String, initial: String): String = {
      var acc = initial
      var i = 0
      while (i < s.length) {
        acc = func(acc, s.charAt(i).toString)
        i += 1
      }
      acc
    }

    reduceString(input, (acc: String, char: String) => {
      if (char == toReplace) acc + newToken
      else acc + char
    }, "")

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

