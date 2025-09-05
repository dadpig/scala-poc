package groupby

object DPK07_01 {


  def groupBy(list: List[Int], groupSize: Int): Array[Array[Int]] = {

    if (list.isEmpty || groupSize <= 0) return Array.empty[Array[Int]]
    val result = scala.collection.mutable.ArrayBuffer[Array[Int]]()
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
  }

}
