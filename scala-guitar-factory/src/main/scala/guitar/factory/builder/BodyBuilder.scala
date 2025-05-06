package guitar.factory.builder

import guitar.factory.model.Body
import guitar.factory.model.types.{Brand, Material}

class BodyBuilder {

  private var id: Long = 0
  private var name: String = ""
  private var brand: Brand = Brand.EPIPHONE
  private var material: Material = Material.MAPLE
  
  def withId(id: Long): BodyBuilder = {
    this.id = id
    this
  }
  
  def withName(name: String): BodyBuilder = {
    this.name = name
    this
  }
  
  def withBrand(brand: Brand): BodyBuilder = {
    this.brand = brand
    this
  }
  
  def withMaterial(material: Material): BodyBuilder = {
    this.material = material
    this
  }
  
  def build: Body = {
    Body(id, name, brand, material)
  }
}
