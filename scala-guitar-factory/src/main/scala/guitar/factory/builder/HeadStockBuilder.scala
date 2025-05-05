package guitar.factory.builder

import guitar.factory.model.HeadStock
import guitar.factory.model.types.{Brand, TuningKeyType}

class HeadStockBuilder {
  private var id: Long = 0
  private var name: String = ""
  private var brand: Brand = Brand.FENDER
  private var tuningKey: TuningKeyType = TuningKeyType.STANDARD
  private var size: Double = 1.0
  private var weight: Double = 1.0
  
  
  def withId(id: Long): HeadStockBuilder = {
    this.id = id
    this
  }
  
  def withName(name: String): HeadStockBuilder = {
    this.name = name
    this
  }
  
  def withBrand(brand: Brand): HeadStockBuilder = {
    this.brand = brand
    this
  }
  
  def withTuningKey(tuningKey: TuningKeyType): HeadStockBuilder = {
    this.tuningKey = tuningKey
    this
  }
  
  def withSize(size: Double): HeadStockBuilder = {
    this.size = size
    this
  }
  
  def withWeight(weight: Double): HeadStockBuilder = {
    this.weight = weight
    this
  }
  
  def build: HeadStock = {
    HeadStock(id, name, brand, tuningKey, size, weight)
  }
}
