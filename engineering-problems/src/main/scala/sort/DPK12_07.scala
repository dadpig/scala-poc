package sort

object DPK12_07 {

  def quicksort(input: Array[Int]): Array[Int] = {

    if (input.length <= 1) input
    else {
      val pivot = input(input.length / 2)
      val less = input.filter(_ < pivot)
      val equal = input.filter(_ == pivot)
      val greater = input.filter(_ > pivot)

      val sortedLess = quicksort(less)
      val sortedGreater = quicksort(greater)
      val result = sortedLess ++ equal ++ sortedGreater
      result
    }

  }




  def main(args: Array[String]): Unit = {
    val input =  Array(5,5,7,4,8,3,2,1)
    val result = quicksort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
