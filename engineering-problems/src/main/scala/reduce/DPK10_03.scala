package reduce

import scala.annotation.tailrec

object DPK10_03 {


  def reduce[T, U](list: List[T], func: (U, T) => U, initial: U): U = {
    @tailrec
    def helper(remaining: List[T], acc: U): U = {
      remaining match {
        case Nil => acc
        case head :: tail => helper(tail, func(acc, head))
      }
    }
    helper(list, initial)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val sumResult = reduce(input, (acc: Int, x: Int) => acc + x, 0)
    println(s"Sum of $input: $sumResult")

    val productResult = reduce(input, (acc: Int, x: Int) => acc * x, 1)
    println(s"Mult of $input: $productResult")
  }


}
