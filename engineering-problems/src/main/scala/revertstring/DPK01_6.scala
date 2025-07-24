package revertstring

object DPK01_6 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      val chars = s.toCharArray
      val result = new StringBuilder
      for (i <- chars.indices.reverse) {
        result.append(chars(i))
      }
      result.toString()
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
