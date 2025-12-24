package groupby

object DPK07_08 {


  private def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {

    val (result, lastGroup) = list.foldLeft((Array.empty[Array[Any]], Array.empty[Any])) {
      case ((acc, currentGroup), elem) =>
        val newGroup = currentGroup :+ elem
        if (newGroup.length == groupSize) {
          (acc :+ newGroup, Array.empty[Any])
        } else {
          (acc, newGroup)
        }
    }
    if (lastGroup.nonEmpty) {
      result :+ lastGroup
    } else {
      result
    }
    
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
