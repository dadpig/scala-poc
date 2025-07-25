package revertstring

object DPK01_9 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      val sb = new StringBuilder(s.length)
      for (i <- s.length - 1 to 0 by -1) {
        sb.append(s.charAt(i))
      }
      sb.toString()
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
