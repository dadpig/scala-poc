package fizzbuzz

object DPK13_01 {


  private def fizzBuzz(intList: List[Int]): List[String] = {
    intList.map { n =>
      (n % 3, n % 5) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case (_, 0) => "Buzz"
        case _ => n.toString
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List.range(1, 100)
    val result = fizzBuzz(input)
    println(s"FizzBuzz : $result")
  }

}