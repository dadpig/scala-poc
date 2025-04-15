package mosquito.game.domain

case class Exterminator(var horizontal: Int,var vertical: Int) {
  
  val VALUE = 1 //default value for exterminator

  def move(board: Array[Array[Int]]): Unit = {
    // Move exterminator in a specific pattern
    if (horizontal < 99 && vertical == 0) {
      horizontal += 1
    } else if (horizontal == 99 && vertical < 99) {
      vertical += 1
    } else if (horizontal > 0 && vertical == 99) {
      horizontal -= 1
    } else if (horizontal == 0 && vertical > 0) {
      vertical -= 1
    }
    if(checkCollision(board)){
      
    }
    board(horizontal)(vertical) = VALUE
    
  }

  def checkCollision(board: Array[Array[Int]]): Boolean = {
    board(horizontal)(vertical) == -1
  }

  def getHorizontal: Int = horizontal

  def getVertical: Int = vertical
}
