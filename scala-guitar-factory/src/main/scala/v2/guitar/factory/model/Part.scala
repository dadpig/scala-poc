package v2.guitar.factory.model

abstract class Part(id: Long, name: String, price: Double) {
  
  def getPrice: Double = price
  
  def getName: String = name
  
   
}
