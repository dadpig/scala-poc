package map

object DPK08_02 {

  private def mapList[T, U](list: List[T], func: T => U): List[U] = {

    if (list.isEmpty) Nil
    else {
      var result = List.fill(list.length)(null.asInstanceOf[U])
      for (i <- list.indices) {
        result = result.updated(i, func(list(i)))
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

