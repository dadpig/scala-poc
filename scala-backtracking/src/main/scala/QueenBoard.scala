import scala.io.StdIn
class QueenBoard(n: Int) {

  def solve(): Option[Array[Array[Int]]] = {
    val board = Array.fill(n)(Array.fill(n)(0))
    if (backTrack(board, 0)) {
      Some(board)
    } else {
      None
    }
  }

  def checkPositionIsSafe(board: Array[Array[Int]], row: Int, index: Int): Boolean = {
    var i = 0
    var j = 0
    while (i < row) {
      if (board(i)(index) eq 1) return false

      i += 1
    }

    while (i >= 0 && j >= 0) {
      if (board(i)(j) eq 1) return false

      i -= 1
      j -= 1
    }

    while (i >= 0 && j < n) {
      if (board(i)(j) eq 1) return false

      i -= 1
      j += 1
    }
    return true
  }

  private def backTrack(board: Array[Array[Int]], col: Int): Boolean =
    if (col >= n) {
      true
    } else {
      (0 until n).exists(row => {
        if (checkPositionIsSafe(board, row, col)) {
          board(row)(col) = 1
          val s = backTrack(board, col + 1)
          if (!s) {
            board(row)(col) = 0 // backtrack
          }
          s
        } else {
          false
        }
      })
    }
}

object QueenBoard {


  def main(args: Array[String]): Unit = {
    println("=====================================")
      println("NQUEENS BOARD")
    val size = Iterator.continually({
        println("Please choose a number higher than 3 to create a board")
        StdIn.readInt()
      }).dropWhile(_ <= 0)
      .take(1)
      .next()
    println(s"Positioning $size queens on a ${size}x${size} board.")
    showResults(new QueenBoard(size))
  }

  private def showResults(board: QueenBoard): Unit = {
    val text = board.solve()
      .map(solution => s"Solution:\n${solution.map(_.mkString(", ")).mkString("\n")}")
      .getOrElse("Solution does not exist!")
    println(text)
  }
}



