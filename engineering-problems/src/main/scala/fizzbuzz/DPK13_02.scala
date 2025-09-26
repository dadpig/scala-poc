package fizzbuzz

object DPK13_02 {


  private def fizzBuzz(intList: List[Int]): List[String] = {
  
    for (i <- intList) yield {
      if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
      else if (i % 3 == 0) "Fizz"
      else if (i % 5 == 0) "Buzz"
      else i.toString
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List.range(1, 100)
    val result = fizzBuzz(input)
    println(s"FizzBuzz : $result")
  }

}