package v2.guitar.factory.builder

import org.scalatest.funsuite.AnyFunSuite


class GuitarBuilderTest extends AnyFunSuite {
  
  test("testCreateGuitar") {
    val model = ModelBuilder.createModel(1, "Stratocaster", "Fender", 
      Array(ModelBuilder.createHead(2, "Headstock", 100.0, "Locking"), 
        ModelBuilder.createBody(3, "Strat", 200.0, "Maple"),
        ModelBuilder.createNeck(4, "Medium Neck", 300.0, "Medium Fret", "Modern TrusRoad")))
    val guitar = GuitarBuilder.createGuitar(1, model)
    assert(guitar.id == 1)
    assert(guitar.model.name == "Stratocaster")
    assert(guitar.model.brand == "Fender")
    assert(guitar.model.bodyParts.length == 3)
    assert(guitar.model.bodyParts(0).getName == "Headstock")
    assert(guitar.model.bodyParts(1).getName == "Strat")
    assert(guitar.model.bodyParts(2).getName == "Medium Neck")
  }
}


