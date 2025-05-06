package v2.guitar.factory.repository

import org.scalatest.funsuite.AnyFunSuite
import v2.guitar.factory.builder.{GuitarBuilder, ModelBuilder}
import v2.guitar.factory.model.Guitar
import v2.guitar.factory.repository.Stock

class StockTest extends  AnyFunSuite {

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
  
    test("test Add Stratocaster Guitar") {
      val guitar: Guitar = createStratoCaster
        Stock.addGuitar(guitar)
        assert(Stock.getStock.contains(guitar))
    }
    
    test("test Remove Stratocaster Guitar") {
      val guitar: Guitar = createStratoCaster
        Stock.addGuitar(guitar)
        Stock.removeGuitar(guitar)
        assert(!Stock.getStock.contains(guitar))
    }
    
    test("test Get Stratocaster Guitar By Model") {
      val guitar: Guitar = createStratoCaster
        Stock.addGuitar(guitar)
      Stock.addGuitar(guitar.copy(id = 2))
      Stock.addGuitar(guitar.copy(id = 3))
      Stock.addGuitar(guitar.copy(id = 4))
      Stock.addGuitar(guitar.copy(id = 5))
      Stock.addGuitar(guitar.copy(id = 6))
      Stock.addGuitar(guitar.copy(id = 7))
      Stock.addGuitar(guitar.copy(id = 8))
      Stock.addGuitar(guitar.copy(id = 9))
        val guitars = Stock.getStockByModel("Stratocaster")
        assert(guitars.contains(guitar))
        assert(guitars.size == 9)
        println(guitars)
    }
    
    test("test Get Stratocaster Guitar By Brand") {
      val guitar: Guitar = createStratoCaster
        Stock.addGuitar(guitar)
      Stock.addGuitar(guitar.copy(id = 2))
      Stock.addGuitar(guitar.copy(id = 3))
      Stock.addGuitar(guitar.copy(id = 4))
      Stock.addGuitar(guitar.copy(id = 5))
      Stock.addGuitar(guitar.copy(id = 6))
      Stock.addGuitar(guitar.copy(id = 7))
      Stock.addGuitar(guitar.copy(id = 8))
      Stock.addGuitar(guitar.copy(id = 9))

      val guitar2: Guitar = createTeleCaster
      Stock.addGuitar(guitar2)
      Stock.addGuitar(guitar2.copy(id = 20))
      Stock.addGuitar(guitar2.copy(id = 21))
      Stock.addGuitar(guitar2.copy(id = 22))
      Stock.addGuitar(guitar2.copy(id = 23))
      Stock.addGuitar(guitar2.copy(id = 24))
      Stock.addGuitar(guitar2.copy(id = 25))
      Stock.addGuitar(guitar2.copy(id = 26))
      Stock.addGuitar(guitar2.copy(id = 27))
      
        val guitars = Stock.getStockByBrand("Fender")
        assert(guitars.contains(guitar))
      assert(guitars.size == 18)
      println(guitars)
    }
    
    test("Test Stock from Gibson and Fender"){
      val guitar: Guitar = createStratoCaster
      Stock.addGuitar(guitar)
      Stock.addGuitar(guitar.copy(id = 2))
      Stock.addGuitar(guitar.copy(id = 3))
      Stock.addGuitar(guitar.copy(id = 4))
      Stock.addGuitar(guitar.copy(id = 5))
      Stock.addGuitar(guitar.copy(id = 6))
      Stock.addGuitar(guitar.copy(id = 7))
      Stock.addGuitar(guitar.copy(id = 8))
      Stock.addGuitar(guitar.copy(id = 9))

      val guitar2: Guitar = createTeleCaster
      Stock.addGuitar(guitar2)
      Stock.addGuitar(guitar2.copy(id = 20))
      Stock.addGuitar(guitar2.copy(id = 21))
      Stock.addGuitar(guitar2.copy(id = 22))
      Stock.addGuitar(guitar2.copy(id = 23))
      Stock.addGuitar(guitar2.copy(id = 24))
      Stock.addGuitar(guitar2.copy(id = 25))
      Stock.addGuitar(guitar2.copy(id = 26))
      Stock.addGuitar(guitar2.copy(id = 27))

      val guitar3: Guitar = createLesPaul
      Stock.addGuitar(guitar3)
      Stock.addGuitar(guitar3.copy(id = 30))
      Stock.addGuitar(guitar3.copy(id = 31))
      Stock.addGuitar(guitar3.copy(id = 32))
      Stock.addGuitar(guitar3.copy(id = 33))
      Stock.addGuitar(guitar3.copy(id = 44))
      Stock.addGuitar(guitar3.copy(id = 45))
      Stock.addGuitar(guitar3.copy(id = 46))
      Stock.addGuitar(guitar3.copy(id = 47))
      val guitars = Stock.getStock
      assert(guitars.contains(guitar))
      assert(guitars.size == 27)
      println(guitars)
    }
}
