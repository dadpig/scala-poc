package revertlist

object DPK02_10 {

  def revertList[T](list: List[T]): List[T] = {
    var result = List[T]()
    var index = list.length - 1
    while (index >= 0) {
      result = result :+ list(index)
      index -= 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val result = revertList(input)
    println(s"Reverted list: $result")
  }

}
