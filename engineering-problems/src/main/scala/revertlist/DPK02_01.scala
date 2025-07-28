package revertlist

object DPK02_01 {

  def revertList[T](list: List[T]): List[T] = {
    if (list.isEmpty) Nil
    else list.last :: revertList(list.init)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val result = revertList(input)
    println(s"Reverted list: $result")
  }

}
