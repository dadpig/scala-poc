package reduce

object DPK10_10 {


  def reduce[T, U](list: List[T], func: (U, T) => U, initial: U): U = {
    list.foldRight(initial)((x, acc) => func(acc, x))
  }

  def reduceFoldLeft[T, U](list: List[T], func: (U, T) => U, initial: U): U = {
    list.foldLeft(initial)((acc, x) => func(acc, x))
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val sumResult = reduce(input, (acc: Int, x: Int) => acc + x, 0)
    println(s"Sum of $input: $sumResult")

    val productResult = reduce(input, (acc: Int, x: Int) => acc * x, 1)
    println(s"Mult of $input: $productResult")
  }


}
