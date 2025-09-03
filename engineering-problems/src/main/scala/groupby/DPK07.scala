package groupby

object DPK07 {


  def groupBy(list: List[Int], groupSize: Int): Array[Array[Int]] = {
    list.grouped(groupSize).map(_.toArray).toArray
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val groupSize = 3
    val result = groupBy(input, groupSize)

    result.foreach(arr => print(arr.mkString("[", ", ", "], ")))
  }

}
