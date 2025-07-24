package revertstring

object DPK01_7 {

  def revertString(s: String): String = {
    if (s.isEmpty) ""
    else {
      var reversed = ""
      var ind = 1
       while (reversed.length != s.length) {
        reversed +=  s.charAt(s.length - ind)
         ind += 1
      }
      reversed
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello, World!"
    val result = revertString(input)
    println(s"Reverted string: $result")
  }

}
