package revertlist

object DPK02_02 {

  def revertList[T](list: List[T]): List[T] = {
    if (list.isEmpty) Nil
    else {
      var result = List[T]()
      for (element <- list) {
        result = element :: result
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
