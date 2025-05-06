package guitar.factory.model

import guitar.factory.model.types.{Color, Sticker}

case class CustomizationDetails(id: Long, component: Part, color: Array[Color], sticker: Array[Sticker], message: String) {

  def calculateCustomizationPrice(customizationDetails: CustomizationDetails): Double = {
    val colorPrice = customizationDetails.color.map(_.getPrice).sum
    val stickerPrice = customizationDetails.sticker.map(_.getPrice).sum
    val totalPrice = colorPrice + stickerPrice
    totalPrice
  }

  override def toString: String = {
    s"CustomizationDetails{id=$id, component=$component, color=${color.mkString("Array(", ", ", ")")}, sticker=${sticker.mkString("Array(", ", ", ")")}, message=$message}"
  }
}
