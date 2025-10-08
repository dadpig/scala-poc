package fizzbuzz

object DPK13_04 {



  private def fizzBuzz(amount: Int): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    var i = 1
    while (i < amount) {

      if (i % 3 == 0 && i % 5 == 0) result += "FizzBuzz"
      else if (i % 3 == 0) result += "Fizz"
      else if (i % 5 == 0) result += "Buzz"
      else result += i.toString
      i += 1
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val amount = 100
    val result = fizzBuzz(amount)
    println(s"FizzBuzz : $result")
  }

}