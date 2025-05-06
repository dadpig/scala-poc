package guitar.factory.model.types

enum FretModel(name: String, price: Double, weight: Double):
  case JUMBO extends FretModel("Jumbo",99.10, 9.10)
  case MEDIUM extends FretModel("Medium",39.10, 4.10)
  case NARROW_TALL extends FretModel("Narrow Tall",39.10, 3.10)
  case VINTAGE extends FretModel("Vintage",19.10, 1.10)
  case EXTRA_JUMBO extends FretModel("Extra Jumbo",29.10, 2.10)
  
  
  def getPrice: Double = price
  
  def getWeight: Double = weight

  override def toString: String = {
    "fret {name: " + name + ", price: " + price + ", weight: " + weight + "}"
  }
end FretModel