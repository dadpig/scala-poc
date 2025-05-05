package v2.guitar.factory.app

import v2.guitar.factory.builder.{GuitarBuilder, ModelBuilder}

object Main extends App{
  println("Hello, Guitar Factory!")

  var model = ModelBuilder.createModel(1, "Stratocaster", "Fender", Array(ModelBuilder.createHead(2, "Headstock", 100.0, "Locking"), ModelBuilder.createBody(3, "Strat", 200.0, "Maple")))
  var guitar = GuitarBuilder.createGuitar(1, model)

  var model2 = ModelBuilder.createModel(4, "Les Paul", "Gibson", Array(ModelBuilder.createHead(5, "Headstock", 200.0, "Narrow Tall"), ModelBuilder.createBody(6, "Classic", 200.0, "Cedar")))
  var guitar2 = GuitarBuilder.createGuitar(2, model)

  println(guitar)
  println(guitar2)
}
