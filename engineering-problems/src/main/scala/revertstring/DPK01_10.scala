package revertstring

object DPK01_10 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {

      val chars = s.toCharArray
      var left = 0
      var right = chars.length - 1
      while (left < right) {
        val temp = chars(left)
        chars(left) = chars(right)
        chars(right) = temp
        left += 1
        right -= 1
      }
      new String(chars)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
