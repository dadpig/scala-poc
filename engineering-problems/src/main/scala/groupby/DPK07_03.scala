package groupby

object DPK07_03 {


  private def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {
    if (list.isEmpty || groupSize <= 0)
      return Array.empty[Array[Any]]

    def recursiveLoop(remaining: List[Any]): Array[Array[Any]] = {
      if (remaining.isEmpty) Array.empty[Array[Any]]
      else {
        val (group, rest) = remaining.splitAt(groupSize)
        Array(group.toArray) ++ recursiveLoop(rest)
      }
    }
    recursiveLoop(list)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val groupSize = 3
    val result = groupBy(input, groupSize)

    result.foreach(arr => print(arr.mkString("[", ", ", "], ")))

    println("")
    val inputStr = List("a","b","c","d","e","f","g","h","i","j")
    val resultStr = groupBy(inputStr, groupSize)
    resultStr.foreach(arr => print(arr.mkString("[", ", ", "], ")))

  }

}
