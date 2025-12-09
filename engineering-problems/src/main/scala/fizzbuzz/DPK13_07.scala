package fizzbuzz

object DPK13_07 {

  private def fizzBuzz(amount: Int): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    if (amount > 1) {
      for (i <- 1 until amount) {
        i match {
          case n if n % 3 == 0 && n % 5 == 0 => result += "FizzBuzz"
          case n if n % 3 == 0 => result += "Fizz"
          case n if n % 5 == 0 => result += "Buzz"
          case _ => result += i.toString
        }
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