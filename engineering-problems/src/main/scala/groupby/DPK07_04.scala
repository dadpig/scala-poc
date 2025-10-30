package groupby

object DPK07_04 {


  private def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {
    val result = scala.collection.mutable.ArrayBuffer[Array[Any]]()
    var i = 0
    while (i < list.length) {
      val group = list.slice(i, i + groupSize)
      result += group.toArray
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
