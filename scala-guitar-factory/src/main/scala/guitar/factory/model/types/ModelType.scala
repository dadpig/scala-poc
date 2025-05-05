package guitar.factory.model.types

enum ModelType(name: String, price: Double) :
  case STRAT extends ModelType("Stratocaster", 799.99)
  case TELE extends ModelType("Telecaster", 888.15)
  case LES_PAUL extends ModelType("Les Paul", 1299.10)
  case SG extends ModelType("SG", 699.99)
  case EXPLORER extends ModelType("Explorer", 899.19)
  case V extends ModelType("V", 999.99)
  case BASIC extends ModelType("Basic", 499.99)
  
  def getPrice: Double = price

  override def toString: String = {
    "model {name: " + name + ", price: " + price + "}"
  }
  
end ModelType
