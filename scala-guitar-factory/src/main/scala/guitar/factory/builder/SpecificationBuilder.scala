package guitar.factory.builder

import guitar.factory.model.{CustomizationDetails, Specification}

class SpecificationBuilder {

  private var id: Long = 0
  private var customizations: Array[CustomizationDetails] = Array.empty
  
  def withId(id: Long): SpecificationBuilder = {
    this.id = id
    this
  }
  
  def withCustomizations(customizations: Array[CustomizationDetails]): SpecificationBuilder = {
    this.customizations = customizations
    this
  }
  
  def build: Specification = {
    Specification(id, customizations)
  }
}
