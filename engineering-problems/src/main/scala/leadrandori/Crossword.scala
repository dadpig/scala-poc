package leadrandori

import util.boundary, boundary.break

object Crossword {

  private def stringToMatrix(s: String): Array[Array[Char]] = {
    s.split("(?<=\\G.{10})").map(_.toCharArray)
  }


  private def findWordInMatrix(matrix: Array[Array[Char]], word: String): Option[(Int, Int)] = {
    val rows = matrix.length
    val cols = if (rows > 0) matrix(0).length else 0
    boundary {
      for (i <- 0 until rows) {
        for (j <- 0 until cols) {
          if (matrix(i)(j) == word.head) {
            if (j + word.length <= cols && matrix(i).slice(j, j + word.length).mkString == word) {
              break(Some((i, j)))
            }
            if (i + word.length <= rows && matrix.slice(i, i + word.length).map(_(j)).mkString == word) {
              break(Some((i, j)))
            }
          }
        }
      }
      None
    }
  }

  def main(args: Array[String]): Unit = {
    val input = "RSPNJAFQTKYFGBMRJTOZGPQEWKODQVSRDTCHKPLUSOWTBAEXMMABBEAMZXRPCIMRTUUZWTYNTPMOCACHTHPOAKGPRHHVVFNMKIQG"
    val matrix = stringToMatrix(input)
    for (row <- matrix) {
      println(row.mkString(" "))
    }

    var word = "BATMAN"
    findWordInMatrix(matrix, word) match {
      case Some((row, col)) => println(s"Found '$word' at position: ($row, $col)")
      case None => println(s"'$word' not found in the matrix.")
    }

    word = "ROBIN"
    findWordInMatrix(matrix, word) match {
      case Some((row, col)) => println(s"Found '$word' at position: ($row, $col)")
      case None => println(s"'$word' not found in the matrix.")
    }

    word = "SUPERMAN"
    findWordInMatrix(matrix, word) match {
      case Some((row, col)) => println(s"Found '$word' at position: ($row, $col)")
      case None => println(s"'$word' not found in the matrix.")
    }
  }
}
