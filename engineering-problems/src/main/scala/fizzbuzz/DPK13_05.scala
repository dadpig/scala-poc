package fizzbuzz

object DPK13_05 {



  private def fizzBuzz(amount: Int): List[String] = {
    (1 until amount).map { n =>
      if (n % 3 == 0 && n % 5 == 0) "FizzBuzz"
      else if (n % 3 == 0) "Fizz"
      else if (n % 5 == 0) "Buzz"
      else n.toString
    }.toList


  }

  def main(args: Array[String]): Unit = {
    val amount = 100
    val result = fizzBuzz(amount)
    println(s"FizzBuzz : $result")
  }

}