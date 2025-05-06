package guitar.factory.builder

import guitar.factory.model.{Neck, Part}
import guitar.factory.model.types.{Brand, FretModel, TrusRoadType}


class NeckBuilder {

  private var id: Long = 0
  private var name: String = ""
  private var brand: Brand = Brand.EPIPHONE
  private var fret: FretModel = FretModel.MEDIUM
  private var trusRoad: TrusRoadType = TrusRoadType.SINGLE
  
  def withId(id: Long): NeckBuilder = {
    this.id = id
    this
  }

  def withName(name: String): NeckBuilder = {
    this.name = name
    this
  }

  def withBrand(brand: Brand): NeckBuilder = {
    this.brand = brand
    this
  }

  def withFretModel(fret: FretModel): NeckBuilder = {
    this.fret = fret
    this
  }
  
  def withTrusRoadType(trusRoad: TrusRoadType): NeckBuilder = {
    this.trusRoad = trusRoad
    this
  }
  
  def build: Neck = {
    Neck(id, name, brand, fret, trusRoad)
  }
}
