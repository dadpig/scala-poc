package revertlist

object DPK02_08{
  
  def revertList[T](list: List[T]): List[T] = {
    list match {
    case Nil => Nil            
    case head :: tail => revertList(tail) :+ head  
    }
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val result = revertList(input)
    println(s"Reverted list: $result")
  }

}
