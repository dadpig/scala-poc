package revertlist

object DPK02_06 {

  def revertList[T](list: List[T]): List[T] = {
    if (list.isEmpty) Nil
    else {
     var result = List.fill(list.length)(null.asInstanceOf[T])
      var size = list.length

     while(size > 0) {
        size -= 1
        result = result.updated(size, list(list.length - 1 - size))
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
