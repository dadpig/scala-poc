package sort


object DPK12_05 {

  def bubble_sort(list: List[Int]): List[Int] = {

    val arr = list.toArray
    val n = arr.length
    var swapped = true
    while (swapped) {
      swapped = false
      for (i <- 1 until n) {
        if (arr(i - 1) > arr(i)) {
          val temp = arr(i - 1)
          arr(i - 1) = arr(i)
          arr(i) = temp
          swapped = true
        }
      }
    }
    arr.toList


  }




  def main(args: Array[String]): Unit = {
    val input = List(5,4,3,2,1)
    val result = bubble_sort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
