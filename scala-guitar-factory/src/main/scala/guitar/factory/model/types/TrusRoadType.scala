package guitar.factory.model.types

enum TrusRoadType(name: String, price: Double, weight: Double) :
  case SINGLE extends TrusRoadType("Single", 9.10, 0.10)
  case DOUBLE extends TrusRoadType("Double", 9.20, 0.20)
  case DUAL extends TrusRoadType("Dual", 0.3, 9.30)
  case VINTAGE extends TrusRoadType("Vintage", 9.40, 0.40)
  case MODERN extends TrusRoadType("Modern", 9.50, 0.50)

  def getPrice: Double = price

  def getWeight: Double = weight

  override def toString: String = {
    "trusRoad {name: " + name + ", price: " + price + ", weight: " + weight + "}"
  }
end TrusRoadType