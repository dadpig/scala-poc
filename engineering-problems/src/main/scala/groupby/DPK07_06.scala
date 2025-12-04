package groupby

object DPK07_06 {


  private def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {

    val result = for {
      i <- list.indices by groupSize
    } yield list.slice(i, i + groupSize).toArray

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
