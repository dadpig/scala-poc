package guitar.factory.model

import guitar.factory.model.types.ModelType

case class Model(id: Long, model: ModelType, parts: Array[Part]) {

  def calculateTotalPrice: Double = {
    val partsPrice = parts.map(_.calculatePrice).sum 
    val totalPrice = model.getPrice + partsPrice
    totalPrice
  }

  def calculateTotalWeight: Double = {
    val partsWeight = parts.map(_.calculateWeight).sum
    val totalWeight = partsWeight
    totalWeight
  }
  
  override def toString: String = {
    s"Model{id=$id, model=$model, parts=${parts.mkString("Array(", ", ", ")")}}"
  }
}
