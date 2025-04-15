package mosquito.game.domain

class Game() {
  var exterminator: Exterminator = Exterminator(99, 0)
  var mosquitos: List[Mosquito] = List.fill(5)(Mosquito(scala.util.Random.nextInt(100), scala.util.Random.nextInt(100)))

  var board: Array[Array[Int]] = Array.fill(100, 100)(0)

  def start(): Unit = {
    // Start the game loop
    while (true) {
      for(mosquito <- mosquitos) {
        if (mosquito.isAlive) {
          mosquito.move(board)
          if (mosquito.getMoveCount % 5 == 0) {
            mosquitos.updated(mosquitos.size, mosquito.reproduce(board))
          }
          board(mosquito.horizontal)(mosquito.vertical) = mosquito.VALUE
        }
        exterminator.move(board)
        if (exterminator.checkCollision(board)) {
          exterminator.horizontal = exterminator.getHorizontal
          exterminator.vertical = exterminator.getVertical
          mosquito.isAlive = false
          board(exterminator.horizontal)(exterminator.vertical) = exterminator.VALUE
        }
      }
      print(board)
      Thread.sleep(1000)
    }
  }





  def getDeadMosquitos: Int = mosquitos.count(!_.isAlive)
}
