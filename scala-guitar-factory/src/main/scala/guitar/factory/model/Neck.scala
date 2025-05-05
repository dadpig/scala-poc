package guitar.factory.model

import guitar.factory.model.types.{Brand, FretModel, TrusRoadType}

case class Neck(id: Long, name: String, brand: Brand, fret: FretModel, trusRoad: TrusRoadType)
  extends Part(id, name, brand) {

  override def calculatePrice: Double = fret.getPrice + trusRoad.getPrice
  
  override def calculateWeight: Double = fret.getWeight + trusRoad.getWeight
  
  override def toString: String = {
    s"Neck{id=$id, name=$name, brand=$brand, fret=$fret, trusRoad=$trusRoad}"
  }
}