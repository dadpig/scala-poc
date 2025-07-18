package revertstring

object DPK01_2 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      var result = ""
      for (c <- s) {
        result = c + result
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
