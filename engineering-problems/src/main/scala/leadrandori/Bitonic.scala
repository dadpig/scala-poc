package leadrandori

object Bitonic {


  def bitonicSeq(n: Int): List[Int] = {
    if (n <= 0) Nil
    else if (n == 1) List(1)
    else {
      val ascending = (1 to n / 2).toList
      val descending = (n / 2 + 1 to n).toList.reverse
      ascending ++ descending
    }
  }

  def bitonic(n: Int, l: Int, r: Int): List[Int] = {
    if (n <= 0) Nil
    else if (n == 1) List(l)
    else {
      val mid = (l + r) / 2
      val ascending = bitonic(n / 2, l, mid)
      val descending = bitonic(n - n / 2, mid + 1, r).reverse
      ascending ++ descending
    }
  }
  def main(args: Array[String]): Unit = {
    val n = 10
    val result = bitonicSeq(n)
    println(s"Bitonic sequence of length $n: $result")

    val bitonicResult = bitonic(5, 1, 4)
    println(s"Bitonic sequence using bitonic function of length $n: $bitonicResult")
  }

}
