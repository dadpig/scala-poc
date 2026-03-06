package leadrandori

object Backtracking {



  def backtrack(n: Int, current: List[Int], result: List[List[Int]]): List[List[Int]] = {
    if (current.length == n) {
      current :: result
    } else {
      var newResult = result
      for (i <- 1 to n) {
        if (!current.contains(i)) {
          newResult = backtrack(n, current :+ i, newResult)
        }
      }
      newResult
    }
  }



  def main(args: Array[String]): Unit = {
    val n = 5
    val result = backtrack(n, Nil, Nil)
    println(s"Backtracking results for n=$n: $result")
  }

}
