package guitar.factory.model

import guitar.factory.model.types.{Brand, TuningKeyType}

case class HeadStock(id: Long, name: String, brand: Brand, tuningKey: TuningKeyType, size: Double, weight: Double) 
  extends Part(id, name, brand) {

  override def calculatePrice: Double = tuningKey.getPrice
  override def calculateWeight: Double = tuningKey.getWeight + weight 
  
  override def toString: String = {
    s"HeadStock{id=$id, name=$name, brand=$brand, tuningKey=$tuningKey, size=$size, weight=$weight}"
  }
}
