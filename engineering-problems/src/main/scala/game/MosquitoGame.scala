package game

object MosquitoGame {



  class Exterminator {
    var x: Int = 0
    var y: Int = 0

    def move(): Unit = {
      x = (x + 1) % 10
      y = (y + 1) % 10
    }
  }

  class  Mosquito {
    var x: Int = 0
    var y: Int = 0
    var movesWithoutBeingKilled: Int = 0

    def move(): Unit = {
      x = scala.util.Random.nextInt(10)
      y = scala.util.Random.nextInt(10)
      movesWithoutBeingKilled += 1
    }


  }

  class Game {
    var mosquitos: List[Mosquito] = List.fill(10)(new Mosquito())
    val exterminator: Exterminator = new Exterminator()
    var killedCount: Int = 0

    def update(): Unit = {
      exterminator.move()
      for (mosquito <- mosquitos) {
        mosquito.move()
        if (mosquito.x == exterminator.x && mosquito.y == exterminator.y) {
          killedCount += 1
          mosquitos = mosquitos.filterNot(_ == mosquito)
        } else if (mosquito.movesWithoutBeingKilled >= 5) {
          val newMosquito = new Mosquito()
          mosquitos = newMosquito :: mosquitos
        }
      }
    }

    def getKilledCount: Int = killedCount
    def getAliveCount: Int = mosquitos.length
  }

  def main(args: Array[String]): Unit = {
    val game = new Game()
    for (_ <- 1 to 40) {
      game.update()
      println(s"Killed: ${game.getKilledCount}, Alive: ${game.getAliveCount}")
    }
  }
}
