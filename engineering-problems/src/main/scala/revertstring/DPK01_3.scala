package revertstring

object DPK01_3 {

  def revertString(s: String): String = {

    if (s.isEmpty) ""
    else {
      val chars = s.toCharArray
      var result = ""
      for (i <- chars.indices.reverse) {
        result += chars(i)
      }
      result
    }
  }
  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
