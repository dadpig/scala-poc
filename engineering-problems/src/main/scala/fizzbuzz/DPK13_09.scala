package fizzbuzz

object DPK13_09 {

  private def fizzBuzz(amount: Int): List[String] = {

    val result = scala.collection.mutable.ListBuffer[String]()
  
      for (i <- 1 until amount) {
        if (i % 3 == 0 && i % 5 == 0){
          result += "FizzBuzz"
        }else if (i % 3 == 0) {
          result += "Fizz"
        }
        else if (i % 5 == 0) {
          result += "Buzz"
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