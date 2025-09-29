package fizzbuzz

object DPK13_03 {


  private def fizzBuzz(intList: List[Int]): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    var i = 0
    while (i < intList.length) {
      val n = intList(i)
      if (n % 3 == 0 && n % 5 == 0) result += "FizzBuzz"
      else if (n % 3 == 0) result += "Fizz"
      else if (n % 5 == 0) result += "Buzz"
      else result += n.toString
      i += 1
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val input = List.range(1, 100)
    val result = fizzBuzz(input)
    println(s"FizzBuzz : $result")
  }

}