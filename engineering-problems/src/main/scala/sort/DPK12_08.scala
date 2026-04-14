package sort

object DPK12_08 {

  def hashSort(input: Array[Int]): Array[Int] = {
    val sorted = new Array[Int](input.length)
    val max = input.max
    val min = input.min
    val range = max - min + 1
    val count = new Array[Int](range)

    for (num <- input) {
      count(num - min) += 1
    }

    var index = 0
    for (i <- count.indices) {
      while (count(i) > 0) {
        sorted(index) = i + min
        index += 1
        count(i) -= 1
      }
    }
    sorted

  }




  def main(args: Array[String]): Unit = {
    val input =  Array(5,5,7,4,8,3,2,1)
    val result = hashSort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
