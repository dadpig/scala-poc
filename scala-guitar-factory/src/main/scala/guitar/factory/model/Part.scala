package guitar.factory.model

import guitar.factory.model.types.Brand

abstract class Part(id: Long, name: String, brand: Brand) {
  
  def calculatePrice: Double
  def calculateWeight: Double

  override def toString: String = {
    s"Part{id=$id, name=$name, brand=$brand}"
  }
}

