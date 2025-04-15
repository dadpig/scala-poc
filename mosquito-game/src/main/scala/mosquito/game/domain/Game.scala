package mosquito.game.domain

import scala.collection.mutable.ArrayBuffer

object Game {
  var exterminator: Exterminator = Exterminator(99, 0)
  var mosquitos: ArrayBuffer[Mosquito] = ArrayBuffer.fill(5)(Mosquito(scala.util.Random.nextInt(100), scala.util.Random.nextInt(100)))
  var board: Array[Array[Int]] = Array.fill(100, 100)(0)

  def start(): Unit = {
    //setup
    for(mosquito <- mosquitos) {
      board(mosquito.horizontal)(mosquito.vertical) = mosquito.VALUE
    }
    board(exterminator.horizontal)(exterminator.vertical) = exterminator.VALUE
    print(matrix2String(board))
    // Start the game loop
    while (true) {
      var it = mosquitos.iterator
      while (it.hasNext) {
        val mosquito = it.next()
        mosquito.move(board)
        if (mosquito.getMoveCount % 5 == 0 && mosquito.isAlive) {
          mosquitos.addOne(mosquito.reproduce(board))
        }
        board(mosquito.horizontal)(mosquito.vertical) = mosquito.VALUE
      }
      exterminator.move(board)
      if (exterminator.checkCollision(board)) {
        exterminator.horizontal = exterminator.getHorizontal
        exterminator.vertical = exterminator.getVertical
        //kill mosquito
        for (mosquito <- mosquitos) {
          if(mosquito.isAlive && mosquito.horizontal == exterminator.horizontal && mosquito.vertical == exterminator.vertical) {
            mosquito.isAlive = false
            board(mosquito.horizontal)(mosquito.vertical) = 0 //release position
          }
        }
        board(exterminator.horizontal)(exterminator.vertical) = exterminator.VALUE
    }

    /*  for(mosquito <- mosquitos) {
        if (mosquito.isAlive) {
          mosquito.move(board)
          if (mosquito.getMoveCount % 5 == 0 && mosquito.isAlive) {
            mosquitos.addOne(mosquito.reproduce(board))
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
      }*/
      print(matrix2String(board))
      Thread.sleep(1000)
    }
  }


  def matrix2String[T](matrix: Array[Array[T]]): String =
    matrix.map(_.mkString(" ")).mkString("\n")



  def getDeadMosquitos: Int = mosquitos.count(!_.isAlive)
}
