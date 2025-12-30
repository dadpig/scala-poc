package filter

object DPK09_08 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {


    val result = scala.collection.mutable.ArrayBuffer[String]()
    for (item <- strings) {
      if (predicate(item)) {
        result += item
      }
    }
    result.toArray
    
  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    val result = filter(input, s => s.contains("ate"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
