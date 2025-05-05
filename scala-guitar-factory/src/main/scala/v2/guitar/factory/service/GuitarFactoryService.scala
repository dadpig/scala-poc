package v2.guitar.factory.service

import v2.guitar.factory.repository.Stock
import v2.guitar.factory.model.Guitar
object GuitarFactoryService {
  
  private val stockRepository = Stock
  
  def addGuitar(guitar: Guitar): Boolean = {
    stockRepository.addGuitar(guitar)
  }
  
  def soldGuitar(guitar: Guitar): Unit = {
    stockRepository.removeGuitar(guitar)
  }
  
  def getStock: List[Guitar] = {
    stockRepository.getStock
  }
  
  def getStockByModel(model: String): List[Guitar] = {
    stockRepository.getStockByModel(model)
  }
  
  def getStockByBrand(brand: String): List[Guitar] = {
    stockRepository.getStockByBrand(brand)
  }
  
  def getGuitarById(id: Long): Option[Guitar] = {
    stockRepository.getGuitarById(id)
  }
  
  def getGuitarPrice(id: Long): Double = {
    getGuitarById(id).get.calculatePrice
  }
  
  def emptyStock: Unit = {
    stockRepository.emptyStock
  }
}


