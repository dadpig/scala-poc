package revertstring

object DPK01 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else s.last + revertString(s.init)
  }
  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
