import scala.io.StdIn
object QueenBord {

  def solveNQueens(size: Int): List[List[String]] = {
    val board = Array.ofDim[Int](size, size) //create a bi-dimensional array to represent the board
    solveNQueensUtil(board, 0)
  }

  // A recursive function to solve the N-Queens problem
  private def solveNQueensUtil(board: Array[Array[Int]], col: Int): List[List[String]] = {
    val size = board.length

    if (col >= size) {
      // return condition when all  sized queens are placed
      List(boardToString(board))
    } else {
      var solutions = List[List[String]]()
      for (row <- 0 until size) {
        //test if position is free
        if (isPositionSafe(board, row, col)) {
          // Place a queen in the current position
          board(row)(col) = 1

          // Recursively place queens in the remaining columns
          // accumulate all possible solution prepends the list items into one list
          solutions = solutions ::: solveNQueensUtil(board, col + 1)

          // Backtrack and remove the queen from the current position
          board(row)(col) = 0
        }
      }
      solutions
    }
  }

  // Check if a queen can be placed in the given position
  private def isPositionSafe(board: Array[Array[Int]], row: Int, col: Int): Boolean = {
    val size = board.length

    // Check  queen in the same line
    for (i <- 0 until col) {
      if (board(row)(i) == 1) {
        return false
      }
    }

    // Check in the upper diagonal
    var auxRow = row //initial position
    var auxCol = col
    while (auxRow >= 0 && auxCol >= 0) {
      if (board(auxRow)(auxCol) == 1) {
        return false
      }
      auxRow -= 1 //up line
      auxCol -= 1 // return column
    }

    // Check in the lower diagonal
    auxRow = row //back to initial position
    auxCol = col
    while (auxRow < size && auxCol >= 0) {
      if (board(auxRow)(auxCol) == 1) {
        return false
      }
      auxRow += 1 //down line
      auxCol -= 1 //return one column
    }

    true //its free
  }

  // Convert the board to string representation
  private def boardToString(board: Array[Array[Int]]): List[String] = {
    board.map(row => row.map(cell => if (cell == 1) "1 " else "0 ").mkString).toList
  }

  def main(args: Array[String]): Unit = {

    println("NQUEENS BOARD SOLUTION")
    val size = Iterator.continually({
        println("Choose a number higher than 3 to create a board")
        StdIn.readInt()
      }).dropWhile(_ <= 3)
      .take(1)
      .next()
    println(s"Positioning $size queens on a ${size}x${size} board.")


    val solutions = solveNQueens(size)

    if (solutions.isEmpty) {
      println(s"No solutions found for $size-Queens problem.")
    } else {
      solutions.zipWithIndex.foreach {
        case (board, index) =>
          println(s"Board: ${index + 1}:")
          board.foreach(println)
          println()
      }
    }
  }
}