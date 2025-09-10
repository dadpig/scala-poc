package groupby

object DPK07_02 {

//Can you refactor the code and create your own group by function, do not use any prebuild function
  def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {

    if (list.isEmpty || groupSize <= 0) return Array.empty[Array[Any]]
    val result = scala.collection.mutable.ArrayBuffer[Array[Any]]()
    var i = 0
    while (i < list.length) {
      val end = math.min(i + groupSize, list.length)
      result += list.slice(i, end).toArray
      i += groupSize
    }
    result.toArray
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
