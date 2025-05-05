package guitar.factory.model.types


enum Sticker(name: String,price: Double):
  case FLAMES extends Sticker("Flames", 1.60)
  case SKULLS extends Sticker("Skulls", 2.99)
  case LIGHTNING extends Sticker("Lightning", 3.60)
  case STARS extends Sticker("Stars", 4.60)
  case STRIPES extends Sticker("Stripes", 5.50)
  case CAMO extends Sticker("Camo", 6.99)
  case ZEBRA extends Sticker("Zebra", 7.50)
  case LEOPARD extends Sticker("Leopard", 8.50)
  case TIGER extends Sticker("Tiger", 9.50)
  case CHEETAH extends Sticker("Cheetah", 10.50)
  case SNAKE extends Sticker("Snake", 11.50)
  case DRAGON extends Sticker("Dragon", 12.99)
  case PHOENIX extends Sticker("Phoenix", 13.50)
  case EAGLE extends Sticker("Eagle", 14.50)
  case OWL extends Sticker("Owl", 15.50)
  case FALCON extends Sticker("Falcon", 16.50)
  case HAWK extends Sticker("Hawk", 17.50)
  case RAVEN extends Sticker("Raven", 18.50)
  case CROW extends Sticker("Crow", 19.99)
  
  def getPrice: Double = price
  
  override def toString: String = {
    "sticker {name: " + name + ", price: " + price + "}"
  }
end Sticker
  