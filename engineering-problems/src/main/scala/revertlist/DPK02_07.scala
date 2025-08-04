package revertlist

object DPK02_07 {

  def revertList[T](list: List[T]): List[T] = {
    if (list.isEmpty) Nil
    else {
     var result = List.fill(list.length)(null.asInstanceOf[T])
      for (i <- list.indices) {
        result = result.updated(i, list(list.length - 1 - i))
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
