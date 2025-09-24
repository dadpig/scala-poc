package sort


object DPK12_02 {


  def bubble_sort(arr: Array[Int]): Array[Int] = {
    val size = arr.length
    val sorted = arr.clone()
    for (i <- 0 until size) {
      for (j <- 1 until (size - i)) {
        if (sorted(j - 1) > sorted(j)) {
          val temp = sorted(j - 1)
          sorted(j - 1) = sorted(j)
          sorted(j) = temp
        }
      }
    }
    sorted
  }




  def main(args: Array[String]): Unit = {
    val input = Array(5,4,3,2,1)
    val result = bubble_sort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
