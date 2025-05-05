package guitar.factory.model

case class Specification(id: Long, customizations: Array[CustomizationDetails]) {

  def totalCustomPrice: Double = {
    var customPrice: Double = 0.0
    for (customization <- customizations) {
      customPrice += customization.calculateCustomizationPrice(customization)
    }
    customPrice
  }
  
  override def toString: String = {
    s"Specification{id=$id, customizations=${customizations.mkString("Array(", ", ", ")")}}"
  }
}

