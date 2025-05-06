package guitar.factory.builder

import guitar.factory.model.types.{Color, Sticker}
import guitar.factory.model.{CustomizationDetails, Part}
class CustomizationDetailsBuilder {

  private var id: Long = 0
  private var component: Part = _
  private var color: Array[Color] = Array.empty
  private var sticker: Array[Sticker] = Array.empty
  private var message: String = ""

  def withId(id: Long): CustomizationDetailsBuilder = {
    this.id = id
    this
  }

  def withComponent(component: Part): CustomizationDetailsBuilder = {
    this.component = component
    this
  }

  def withColor(color: Array[Color]): CustomizationDetailsBuilder = {
    this.color = color
    this
  }

  def withSticker(sticker: Array[Sticker]): CustomizationDetailsBuilder = {
    this.sticker = sticker
    this
  }

  def withMessage(message: String): CustomizationDetailsBuilder = {
    this.message = message
    this
  }

  def build: CustomizationDetails = {
    CustomizationDetails(id, component, color, sticker, message)
  }
}
