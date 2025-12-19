package filter

object DPK09_07 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {

    strings.map {
      case str if predicate(str) => str
      case _ => null
    }.filter(_ != null)
    
  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
