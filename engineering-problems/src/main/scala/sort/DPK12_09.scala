package sort

object DPK12_09 {

  def merge_sort(input: Array[Int]): Array[Int] = {
    if (input.length <= 1) input
    else {
      val mid = input.length / 2
      val left = merge_sort(input.slice(0, mid))
      val right = merge_sort(input.slice(mid, input.length))
      merge(left, right)
    }
  }

  def merge(left: Array[Int], right: Array[Int]): Array[Int] = {
    val merged = new Array[Int](left.length + right.length)
    var i = 0
    var j = 0
    var k = 0
    while (i < left.length && j < right.length) {
      if (left(i) <= right(j)) {
        merged(k) = left(i)
        i += 1
      } else {
        merged(k) = right(j)
        j += 1
      }
      k += 1
    }
    merged
  }


  def main(args: Array[String]): Unit = {
    val input =  Array(5,5,7,4,8,3,2,1)
    val result = merge_sort(input)
    println(s" list: ${input.mkString(", ")}")
    println(s"Sorted list: ${result.mkString(", ")}")
  }
}
