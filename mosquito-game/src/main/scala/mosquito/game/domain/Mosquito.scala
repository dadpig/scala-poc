package mosquito.game.domain

case class Mosquito(var horizontal: Int, var vertical: Int) {
  var isAlive: Boolean = true
  var moveCount: Int = 0
  val VALUE = -1
  
  def move(board:Array[Array[Int]]): Unit = {
    if (isAlive) {

      //to guarantee that the mosquito will not move to the same position and not override another mosquito
      var newHorizontal = scala.util.Random.nextInt(100)
      var newVertical = scala.util.Random.nextInt(100)
      while(newHorizontal == horizontal && newVertical == vertical
        && board(newHorizontal)(newVertical) != VALUE){
        newHorizontal = scala.util.Random.nextInt(100)
        newVertical = scala.util.Random.nextInt(100)
      }
      
      //check colision 
      if (!checkCollision(newHorizontal, newVertical, board)) {
        this.horizontal = newHorizontal
        this.vertical = newVertical
        moveCount += 1
      }
    }
  }
  
  def getMoveCount: Int = moveCount
  
  def checkCollision(newHorizontal: Int, newVertical: Int, board:Array[Array[Int]]): Boolean = {
    var collision :Boolean = false    
    if (board(newHorizontal)(newVertical) == 1) {
      //mosquito flies straight to exterminator and will be killed
      isAlive = false
      board(horizontal)(vertical) = 0 //release position
      collision = true
    }
    collision
  }
  
  def reproduce(board:Array[Array[Int]]): Mosquito = {
    Mosquito(scala.util.Random.nextInt(100), scala.util.Random.nextInt(100))
  }
}
