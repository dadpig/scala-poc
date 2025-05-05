package guitar.factory.builder

import guitar.factory.model.{Model, Part}
import guitar.factory.model.types.ModelType

class ModelBuilder {

  private var id: Long = 0
  private var model: ModelType = ModelType.BASIC
  private var parts: Array[Part] = Array.empty

  def withId(id: Long): ModelBuilder = {
    this.id = id
    this
  }

  def withModel(model: ModelType): ModelBuilder = {
    this.model = model
    this
  }

  def withParts(parts: Array[Part]): ModelBuilder = {
    this.parts = parts
    this
  }

  def build: Model = {
    Model(id, model, parts)
  }
}

