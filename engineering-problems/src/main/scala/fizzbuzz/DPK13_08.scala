package fizzbuzz

object DPK13_08 {

  private def fizzBuzz(amount: Int): List[String] = {

    def fizzBuzzValue(n: Int): String = {
      if (n % 3 == 0 && n % 5 == 0) "FizzBuzz"
      else if (n % 3 == 0) "Fizz"
      else if (n % 5 == 0) "Buzz"
      else n.toString
    }

    val result = scala.collection.mutable.ListBuffer[String]()
    if (amount > 1) {
      for (i <- 1 until amount) {
        result += fizzBuzzValue(i)
      }
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val amount = 100
    val result = fizzBuzz(amount)
    println(s"FizzBuzz : $result")
  }

}