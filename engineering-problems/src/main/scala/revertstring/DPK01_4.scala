package revertstring

object DPK01_4 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      (for (i <- s.length - 1 to 0 by -1) yield {
        s.charAt(i)
      }).mkString("")
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
