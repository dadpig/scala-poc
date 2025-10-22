package map

import scala.annotation.tailrec

object DPK08_03 {

  private def mapList[T, U](list: List[T], func: T => U): List[U] = {

    @tailrec
    def mapHelper(remaining: List[T], acc: List[U]): List[U] = {
      if (remaining.isEmpty) acc.reverse
      else mapHelper(remaining.tail, func(remaining.head) :: acc)
    }

    mapHelper(list, Nil)
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

