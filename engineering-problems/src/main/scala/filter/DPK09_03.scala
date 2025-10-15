package filter

object DPK09_03 {


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
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
