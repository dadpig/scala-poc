package leadrandori

object RadixSort {
  val buckets = 10
  def countingSort(arr: Array[Int], exp: Int): Unit = {
    val output = new Array[Int](arr.length)
    val count = new Array[Int](buckets)

    for (i <- arr.indices) {
      count((arr(i) / exp) % 10) += 1
    }

    for (i <- 1 until buckets) {
      count(i) += count(i - 1)
    }

    for (i <- arr.indices.reverse) {
      output(count((arr(i) / exp) % buckets) - 1) = arr(i)
      count((arr(i) / exp) % buckets) -= 1
    }

    for (i <- arr.indices) {
      arr(i) = output(i)
    }
  }

  def radixSort(arr: Array[Int]): Unit = {
    val max = arr.max
    var exp = 1
    while (max / exp > 0) {
      countingSort(arr, exp)
      exp *= buckets
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(170, 45, 75, 90, 802, 24, 2, 66, 1002, 123, 456, 789, 321, 654, 987)
    radixSort(arr)
    println("Sorted array: " + arr.mkString(", "))
  }

}
