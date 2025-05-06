package guitar.factory.model.types

enum Material(name: String, price: Double, weight: Double):
  case MAPLE extends Material("Maple", 100.0, 2.0)
  case CEDAR extends Material("Cedar", 150.0, 2.5)
  case PINE extends Material("Pine", 200.0, 3.0)
  case ALUMINUM extends Material("Aluminum", 250.0, 3.5)
  case STEEL extends Material("Steel", 300.0, 4.0)
  case TITANIUM extends Material("Titanium", 200.0, 3.0)
  case CERAMIC extends Material("Ceramic", 200.0, 3.0)
  case GLASS extends Material("Glass", 200.0, 3.0)
  case POLYCARBONATE extends Material("Polycarbonate", 200.0, 3.0)
  
  def getPrice: Double = price
  
  def getWeight: Double = weight
  
  override def toString: String = {
    "material {name: " + name + ", price: " + price + ", weight: " + weight + "}"
  }
end Material