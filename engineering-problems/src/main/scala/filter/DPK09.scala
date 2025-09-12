package filter

object DPK09 {

  def filter(numbers: List[Int]): List[Int] = {
    numbers.filter(_ % 2 == 0)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = filter(input)
    println(s"Even numbers: $result")
  }

}
