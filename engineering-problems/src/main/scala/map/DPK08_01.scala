package map

object DPK08_01 {

  private def mapList[T, U](list: List[T], func: T => U): List[U] = {

    if (list.isEmpty) Nil
    else {
      var result = List.fill(list.length)(null.asInstanceOf[U])
      var size = list.length

      while(size > 0) {
        size -= 1
        result = result.updated(size, func(list(list.length - 1 - size)))
      }

      result
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val result = mapList(input, (x: Int) => x * 2)
    println(s"$input double values: $result")

    val inputStr = List("a", "b", "c", "d")
    val resultStr = mapList(inputStr, (s: String) => s.toUpperCase)
    println(s"$inputStr capitalize letters: $resultStr")
  }
}
