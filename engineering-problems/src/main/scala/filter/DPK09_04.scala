package filter

object DPK09_04 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {
    strings.foldLeft(Array[String]()) { (result, s) =>
      if (predicate(s)) result :+ s
      else result
    }
  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
