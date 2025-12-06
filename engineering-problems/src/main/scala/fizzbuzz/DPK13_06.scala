package fizzbuzz

import scala.annotation.tailrec

object DPK13_06 {



  private def fizzBuzz(amount: Int): List[String] = {

    @tailrec
    def fizzBuzzRec(n: Int, acc: List[String]): List[String] = {
      if (n >= amount) acc
      else {
        val value = (n % 3, n % 5) match {
          case (0, 0) => "FizzBuzz"
          case (0, _) => "Fizz"
          case (_, 0) => "Buzz"
          case _ => n.toString
        }
        fizzBuzzRec(n + 1, acc :+ value)
      }
    }
    fizzBuzzRec(1, List())


  }

  def main(args: Array[String]): Unit = {
    val amount = 100
    val result = fizzBuzz(amount)
    println(s"FizzBuzz : $result")
  }

}