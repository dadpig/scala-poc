package guitar.factory.model.types

enum TuningKeyType(name: String, price: Double, weight: Double):

  case STANDARD extends TuningKeyType("Standard", 1.0, 100.0)
  case LOCKING extends TuningKeyType("Locking", 2.5, 120.0)
  case VINTAGE extends TuningKeyType("Vintage", 5.0, 140.0)
  case MODERN extends TuningKeyType("Modern", 6.5, 160.0)
  case CLASSIC extends TuningKeyType("Classic", 9.5, 200.0)


  def getPrice: Double = price

  def getWeight: Double = weight
  
  override def toString: String = {
    "tuningKey {name: " + name + ", price: " + price + ", weight: " + weight + "}"
  }
end TuningKeyType