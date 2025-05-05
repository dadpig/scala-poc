package guitar.factory.model

import guitar.factory.model.types.{Brand, Material}

case class Body(id: Long, name: String, brand: Brand, material: Material)
  extends Part(id, name, brand){
  
  override def calculatePrice: Double = material.getPrice
  
  override def calculateWeight: Double = material.getWeight
  
  override def toString: String = {
    s"Body{id=$id, name=$name, brand=$brand, material=$material}"
  }
}

