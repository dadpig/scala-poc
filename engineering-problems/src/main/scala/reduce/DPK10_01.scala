package reduce

object DPK10_01 {


  private def reduce[Int](list: List[Int], func: (Int, Int) => Int, initial: Int): Int = {
    var acc = initial
    for (elem <- list) {
      acc = func(acc, elem)
    }
    acc

  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val sumResult = reduce(input, (acc: Int, x: Int) => acc + x, 0)
    println(s"Sum of $input: $sumResult")

    val productResult = reduce(input, (acc: Int, x: Int) => acc * x, 1)
    println(s"Mult of $input: $productResult")
  }


}
