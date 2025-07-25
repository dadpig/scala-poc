package revertstring

object DPK01_8 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      val chars = s.toCharArray
      val result = new StringBuilder
      var left = 0
      var right = chars.length - 1
      while (left <= right) {
        result.append(chars(right))
        right -= 1
        left += 1
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
