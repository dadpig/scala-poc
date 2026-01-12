package twodwalk

object DPK14_03 {

  class Fighter(val name: String) {
    override def toString: String = name
  }

  class FighterGrid(val grid: Array[Array[Fighter]]) {

    override def toString: String = {
      grid.map(row => row.map(fighter => if (fighter != null) fighter.name else "None").mkString("[", ", ", "]")).mkString("\n")
    }

    def getFighter(x: Int, y: Int): Fighter = {
      grid(x)(y)
    }

    def moveFighter(startX: Int, startY: Int, moves: List[String]): (Int, Int) = {
      var x = startX
      var y = startY
      val numRows = grid.length
      val numCols = grid(0).length
      for (move <- moves) {
        move match {
          case "up" =>
            x = (x - 1 + numRows) % numRows
          case "down" =>
            x = (x + 1) % numRows
          case "left" =>
            y = (y - 1 + numCols) % numCols
          case "right" =>
            y = (y + 1) % numCols
          case _ =>
        }
      }
      (x, y)
    }
  }


  def main(args: Array[String]): Unit = {
    val fighterGrid = new FighterGrid(Array(
      Array(new Fighter("Ryu"), new Fighter("E.Honda"), new Fighter("Blanka"), new Fighter("Guile"), new Fighter("Balrog"), new Fighter("Vega")),
      Array(new Fighter("Ken"), new Fighter("Chun Li"), new Fighter("Zangief"), new Fighter("Dhalsim"), new Fighter("Sagat"), new Fighter("M.Bison"))
    ))

    val startX = 0
    val startY = 2

    val moves = List("down", "right")
    println(fighterGrid.toString)
    val (finalX, finalY) = fighterGrid.moveFighter(startX, startY, moves)
    println(s"Initial position: ($finalX, $finalY")
    val finalFighter = fighterGrid.getFighter(finalX, finalY)
    println(s"Final position: ($finalX, $finalY) - Character: ${if (finalFighter != null) finalFighter.name else "None"}")
  }

}
