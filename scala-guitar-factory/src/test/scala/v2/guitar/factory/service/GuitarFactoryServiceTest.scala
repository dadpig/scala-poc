package v2.guitar.factory.service

import org.scalatest.funsuite.AnyFunSuite
import v2.guitar.factory.builder.{GuitarBuilder, ModelBuilder}
import v2.guitar.factory.model.Guitar

class GuitarFactoryServiceTest extends AnyFunSuite{

  def createStratoCaster: Guitar = {
    val model = ModelBuilder.createModel(1, "Stratocaster", "Fender",
      Array(ModelBuilder.createHead(2, "Headstock", 100.0, "Locking"),
        ModelBuilder.createBody(3, "Strat", 200.0, "Maple"),
        ModelBuilder.createNeck(4, "Medium Neck", 300.0, "Medium Fret", "Modern TrusRoad")))
    GuitarBuilder.createGuitar(1, model)
  }

  def createTeleCaster: Guitar = {
    val model = ModelBuilder.createModel(2, "Telecaster", "Fender",
      Array(ModelBuilder.createHead(5, "Headstock", 99.0, "Tall"),
        ModelBuilder.createBody(6, "Tele", 299.0, "Maple"),
        ModelBuilder.createNeck(7, "MJumbo Neck", 499.0, "Medium Fret", "Modern TrusRoad")))
    GuitarBuilder.createGuitar(20, model)
  }

  def createLesPaul: Guitar = {
    val model = ModelBuilder.createModel(3, "Les Paul", "Gibson",
      Array(ModelBuilder.createHead(8, "Headstock", 200.0, "Narrow Tall"),
        ModelBuilder.createBody(9, "Classic", 200.0, "Cedar"),
        ModelBuilder.createNeck(10, "Jumbo Neck", 300.0, "Double Fret", "Classic TrusRoad")))
    GuitarBuilder.createGuitar(30, model)
  }


  test("testAddGuitar") {
    val guitar = createStratoCaster
    assert(true, GuitarFactoryService.addGuitar(guitar))
    GuitarFactoryService.emptyStock
  }

  test("testSoldGuitar") {
    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    GuitarFactoryService.soldGuitar(guitar)
    assert(GuitarFactoryService.getStock.isEmpty)
    GuitarFactoryService.emptyStock
  }

  test("testGetStock") {

    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    assert(GuitarFactoryService.getStock.size == 1)
    GuitarFactoryService.emptyStock
  }

  test("testGetStock with 10 items") {

    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    GuitarFactoryService.addGuitar(guitar.copy(id = 2))
    GuitarFactoryService.addGuitar(guitar.copy(id = 3))
    GuitarFactoryService.addGuitar(guitar.copy(id = 4))
    GuitarFactoryService.addGuitar(guitar.copy(id = 5))
    GuitarFactoryService.addGuitar(guitar.copy(id = 6))
    GuitarFactoryService.addGuitar(guitar.copy(id = 7))
    GuitarFactoryService.addGuitar(guitar.copy(id = 8))
    GuitarFactoryService.addGuitar(guitar.copy(id = 9))
    GuitarFactoryService.addGuitar(guitar.copy(id = 10))
    assert(GuitarFactoryService.getStock.size == 10)
    GuitarFactoryService.emptyStock
  }

  test("testSold Stratocaster with a 10 items in stock, should be 9") {

    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    GuitarFactoryService.addGuitar(guitar.copy(id = 2))
    GuitarFactoryService.addGuitar(guitar.copy(id = 3))
    GuitarFactoryService.addGuitar(guitar.copy(id = 4))
    GuitarFactoryService.addGuitar(guitar.copy(id = 5))
    GuitarFactoryService.addGuitar(guitar.copy(id = 6))
    GuitarFactoryService.addGuitar(guitar.copy(id = 7))
    GuitarFactoryService.addGuitar(guitar.copy(id = 8))
    GuitarFactoryService.addGuitar(guitar.copy(id = 9))
    GuitarFactoryService.addGuitar(guitar.copy(id = 10))
    assert(GuitarFactoryService.getStock.size == 10)
    GuitarFactoryService.soldGuitar(guitar)
    assert(GuitarFactoryService.getStock.size == 9)
    GuitarFactoryService.emptyStock
  }

  test("testGetStockByModel") {
    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    GuitarFactoryService.addGuitar(guitar.copy(id = 2))
    GuitarFactoryService.addGuitar(guitar.copy(id = 3))
    GuitarFactoryService.addGuitar(guitar.copy(id = 4))
    GuitarFactoryService.addGuitar(guitar.copy(id = 5))
    GuitarFactoryService.addGuitar(guitar.copy(id = 6))
    GuitarFactoryService.addGuitar(guitar.copy(id = 7))
    GuitarFactoryService.addGuitar(guitar.copy(id = 8))
    GuitarFactoryService.addGuitar(guitar.copy(id = 9))
    GuitarFactoryService.addGuitar(guitar.copy(id = 10))
    assert(GuitarFactoryService.getStockByModel("Stratocaster").size == 10)
    GuitarFactoryService.emptyStock
  }
  
  test("test guitar price") {
    val guitar = createStratoCaster
    GuitarFactoryService.addGuitar(guitar)
    assert(GuitarFactoryService.getGuitarPrice(1) == 600.0)
    GuitarFactoryService.emptyStock
  }
  

}
