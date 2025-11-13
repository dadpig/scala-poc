package filter

object DPK09_05 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {

    val result = strings.flatMap { s =>
      if (predicate(s)) Array(s)
      else Array[String]()
    }
    result

  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
