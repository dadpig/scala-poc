package map

import scala.annotation.tailrec

object DPK08_04 {

  private def mapList[T, U](list: List[T], func: T => U): List[U] = {

    @tailrec
    def cutHeadRec(remaining: List[T], acc: List[U]): List[U] = {
      remaining match {
        case Nil => acc
        case head :: tail => cutHeadRec(tail, acc :+ func(head))
      }
    }

    cutHeadRec(list, Nil)
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

