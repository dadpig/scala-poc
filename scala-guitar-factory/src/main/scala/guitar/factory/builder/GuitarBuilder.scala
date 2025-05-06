package guitar.factory.builder

import guitar.factory.model.{Guitar, Model, Specification}

class GuitarBuilder {

  private var id: Long = 0
  private var model: Option[Model] = None
  private var customization: Option[Specification] = None
  private var year: Option[Int] = None



  def withId(id: Long): GuitarBuilder = {
    this.id = id
    this
  }

  def withModel(model: Model): GuitarBuilder = {
    this.model = Some(model)
    this
  }

  def withCustomization(customization: Specification): GuitarBuilder = {
    this.customization = Some(customization)
    this
  }

  def withYear(year: Int): GuitarBuilder = {
    this.year = Some(year)
    this
  }

  def build(): Guitar = {
    Guitar(id, model.get, customization.getOrElse(SpecificationBuilder().build), year.get)
  }
}
