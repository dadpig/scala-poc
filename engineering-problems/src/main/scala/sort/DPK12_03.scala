package sort

object DPK12_03 {

  def bubble_sort(arr: Array[Int]): Array[Int] = {
    @annotation.tailrec
    def bubbleRec(sorted: Array[Int], n: Int): Array[Int] = {
      if (n == 1) sorted
      else {
        var swapped = false
        for (i <- 1 until n) {
          if (sorted(i - 1) > sorted(i)) {
            val temp = sorted(i - 1)
            sorted(i - 1) = sorted(i)
            sorted(i) = temp
            swapped = true
          }
        }
        if (!swapped) sorted
        else bubbleRec(sorted, n - 1)
      }
    }
    bubbleRec(arr.clone(), arr.length)
  }




  def main(args: Array[String]): Unit = {
    val input = Array(5,4,3,2,1)
    val result = bubble_sort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
