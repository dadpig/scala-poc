package v2.guitar.factory.repository

import v2.guitar.factory.model.Guitar

object Stock {
  
  private var stock: List[Guitar] = List()
  
  
  def addGuitar(guitar: Guitar): Boolean = {
    val sizeBefore = stock.size
    stock = stock :+ guitar
    sizeBefore < stock.size
  }
  
  
  def removeGuitar(guitar: Guitar): Boolean = {
    val sizeBefore = stock.size
    stock = stock.filterNot(_.id == guitar.id)
    sizeBefore > stock.size
  }
  
  
  def getStock: List[Guitar] = stock
  
  
  def getStockByModel(model: String): List[Guitar] = stock.filter(_.model.name == model)
  
  
  def getStockByBrand(brand: String): List[Guitar] = stock.filter(_.model.brand == brand)
  
  def getGuitarById(id: Long): Option[Guitar] = stock.find(_.id == id)
  
  def emptyStock: Unit = stock = List()
}
