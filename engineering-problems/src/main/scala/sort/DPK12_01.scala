package sort

object DPK12_01 {


  private def bubble_sort(list: List[Int]): List[Int] = {
    if (list.isEmpty) return Nil

    val sorted = list.toArray
    val size = list.length
    var swapped = true

    while (swapped) {
      swapped = false
      for (i <- 1 until size) {
        if (sorted(i - 1) > sorted(i)) {
          val temp = sorted(i - 1)
          sorted(i - 1) = sorted(i)
          sorted(i) = temp
          swapped = true
        }
      }
    }

    sorted.toList
  }


  def main(args: Array[String]): Unit = {
    val input = List(5,4,3,2,1)
    val result = bubble_sort(input)
    println(s" list: $input")
    println(s"Sorted list: $result")
  }
}
