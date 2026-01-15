package filter

object DPK09_09 {


  def filter(strings: Array[String], predicate: String => Boolean): Array[String] = {


    val result = scala.collection.mutable.ArrayBuffer[String]()
    var counter = 0
    while (counter < strings.length) {
      val item = strings(counter)
      if (predicate(item)) {
        result += item
      }
      counter = counter + 1
    }
    result.toArray
    
  }

  def main(args: Array[String]): Unit = {
    val input = Array("apple", "banana", "cherry", "date", "elderberry", "kate", "mate", "orange")
    println(s"Filtering strings ${input.mkString(", ")} that contain the letter 'a'")
    val result = filter(input, s => s.contains("a"))
    println(s"Filtered strings: ${result.mkString(", ")}")
  }

}
