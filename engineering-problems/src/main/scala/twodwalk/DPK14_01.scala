package twodwalk

object DPK14_01 {

  private def moveFighter(grid: Array[Array[String]], startX: Int, startY: Int, moves: List[String]): (Int, Int) = {
    var x = startX
    var y = startY
    val numRows = grid.length
    val numCols = grid(0).length

    for (move <- moves) {
      move match {
        case "up" => x = (x - 1 + numRows) % numRows
        case "down" => x = (x + 1) % numRows
        case "left" => y = (y - 1 + numCols) % numCols
        case "right" => y = (y + 1) % numCols
        case _ =>
      }
    }
    (x, y)
  }



  def main(args: Array[String]): Unit = {
    val grid = Array(
      Array("Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"),
      Array("Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison")
    )

    val startX = 0
    val startY = 0

    val moves = List("up")
    val (firstX, firstY) = moveFighter(grid, 0, 0, moves)
    println(s"First position: ($firstX, $firstY) - Character: ${grid(firstX)(firstY)}")

    val newMoves = moves ++ List("right", "right", "down")
    val (finalX, finalY) = moveFighter(grid, 0,0, newMoves)
    println(s"Final position: ($finalX, $finalY) - Character: ${grid(finalX)(finalY)}")
  }


}
