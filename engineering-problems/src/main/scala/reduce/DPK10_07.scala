package reduce

object DPK10_07 {


  def reduce[T, U](list: List[T], func: (U, T) => U, initial: U): U = {

    list match {
      case Nil => initial
      case _ =>
        var acc = initial
        for (element <- list) {
          acc = func(acc, element)
        }
        acc
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val sumResult = reduce(input, (acc: Int, x: Int) => acc + x, 0)
    println(s"Sum of $input: $sumResult")

    val productResult = reduce(input, (acc: Int, x: Int) => acc * x, 1)
    println(s"Mult of $input: $productResult")
  }


}
