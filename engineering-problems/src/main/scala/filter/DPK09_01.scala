package filter

object DPK09_01 {

  def filter(numbers: List[Int]): List[Int] = {

    if (numbers.isEmpty) Nil
    else {
      var result = List.fill(numbers.length)(0)
      var size = numbers.length
      var count = 0

      while(size > 0) {
        size -= 1
        if (numbers(numbers.length - 1 - size) % 2 == 0) {
          result = result.updated(count, numbers(numbers.length - 1 - size))
          count += 1
        }
      }

      result.take(count)
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = filter(input)
    println(s"Even numbers: $result")
  }

}
