package filter

object DPK09_02 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {
    var result = Array[String]()
    for (s <- strings) {
      if (predicate(s)) {
        result = result :+ s
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry")
    val result = filter(input, s => s.length > 5)
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
