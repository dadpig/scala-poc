package revertlist

object DPK02_05 {

  def revertList[T](list: List[T]): List[T] = {
    if (list.isEmpty) Nil
    else {
     var result = List.fill(list.length)(null.asInstanceOf[T])

      var left = 0
      var right = list.length - 1
      while (left <= right) {
        val temp = list(left)
        result = result.updated(left, list(right))
        result = result.updated(right, temp)
        left += 1
        right -= 1
      }

      result
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val result = revertList(input)
    println(s"Reverted list: $result")
  }

}
