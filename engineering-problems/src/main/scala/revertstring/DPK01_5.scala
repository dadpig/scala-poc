package revertstring

object DPK01_5 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      val lastChar = s.last
      val restOfString = s.init
      lastChar + revertString(restOfString)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
