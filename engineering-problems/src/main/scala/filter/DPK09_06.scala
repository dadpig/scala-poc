package filter

object DPK09_06 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {

    strings.collect {
      case s if predicate(s) => s
    }

  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
