package sort

import scala.annotation.tailrec

object DPK12_04 {

  def bubble_sort(list: List[Int]): List[Int] = {

    @tailrec
    def sort(remaining: List[Int], passes: Int): List[Int] = {
      if (passes <= 0) remaining
      else {
        val (sorted, swapped) = bubble(remaining)
        if (!swapped) sorted
        else sort(sorted, passes - 1)
      }
    }
    
    def bubble(list: List[Int]): (List[Int], Boolean) = list match {
      case x :: y :: tail if x > y =>
        val (sorted, swapped) = bubble(x :: tail)
        (y :: sorted, true)
      case x :: tail =>
        val (sorted, swapped) = bubble(tail)
        (x :: sorted, swapped)
      case Nil => (Nil, false)
    }

    sort(list, list.length)
  }




  def main(args: Array[String]): Unit = {
    val input = List(5,4,3,2,1)
    val result = bubble_sort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
