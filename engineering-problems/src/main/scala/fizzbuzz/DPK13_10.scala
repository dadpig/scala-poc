package fizzbuzz

object DPK13_10 {

  private def fizzBuzz(amount: Int): List[String] = {

    val result = scala.collection.mutable.ListBuffer[String]()
    var i: Int = 1
      while (i < amount)  {
        if (i % 3 == 0 && i % 5 == 0){
          result += s"FizzBuzz: $i"
        }else if (i % 3 == 0) {
          result += s"Fizz: $i"
        }
        else if (i % 5 == 0) {
          result += s"Buzz: $i"
        }
        i = i +1
      }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val amount = 100
    val result = fizzBuzz(amount)
    println(s"FizzBuzz : $result")
  }

}