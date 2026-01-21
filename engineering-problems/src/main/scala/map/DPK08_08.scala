package map

import scala.collection.mutable.ListBuffer

object DPK08_08 {

  private def mapList[T, U](list: List[T], func: T => U): List[U] = {

    val result = ListBuffer[U]()
    var currentList = list
    while (currentList.nonEmpty) {
      val head = currentList.head
      result += func(head)
      currentList = currentList.tail
    }
    result.toList
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

