package guitar.factory.model.types

enum Color(color: String,price: Double):
  case RED extends Color("Red", 10.0)
  case BLUE extends Color("Blue", 10.0)
  case GREEN extends Color("Green", 20.10)
  case YELLOW extends Color("Yellow", 10.0)
  case BLACK extends Color("Black", 21.10)
  case WHITE extends Color("White", 21.10)
  case ORANGE extends Color("Orange", 21.10)
  case PURPLE extends Color("Purple", 21.10)
  case PINK extends Color("Pink", 25.10)
  case BROWN extends Color("Brown", 10.10)
  case GREY extends Color("Grey", 15.10)
  case SILVER extends Color("Silver", 33.20)
  case GOLD extends Color("Gold", 50.30)
  case BRONZE extends Color("Bronze", 40.20)
  case CHROME extends Color("Chrome", 45.15)
  case ALUMINIUM extends Color("Aluminium", 60.30)
  case TITANIUM extends Color("Titanium", 99.30)
  case STEEL extends Color("Steel", 124.20)
  case WOOD extends Color("Wood", 99.25)
  
  def getPrice: Double = price
  
  override def toString: String = {
    "color {name: " + color + ", price: " + price + "}"
  }
end Color