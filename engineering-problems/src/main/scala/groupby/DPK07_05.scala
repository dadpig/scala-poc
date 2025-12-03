package groupby

import scala.annotation.tailrec

object DPK07_05 {


  private def groupBy(list: List[Any], groupSize: Int): Array[Array[Any]] = {

    @tailrec
    def helper(remaining: List[Any], acc: Array[Array[Any]]): Array[Array[Any]] = {
      if (remaining.isEmpty) acc
      else {
        val (group, rest) = remaining.splitAt(groupSize)
        helper(rest, acc :+ group.toArray)
      }
    }
    helper(list, Array.empty[Array[Any]])
    
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
