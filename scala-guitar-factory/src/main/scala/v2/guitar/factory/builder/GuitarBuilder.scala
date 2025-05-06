package v2.guitar.factory.builder

import v2.guitar.factory.model.{Body, Head, Neck, Guitar, Model}


object GuitarBuilder {
  
  def createGuitar(id: Long, model: Model) = {
    Guitar(id, model)
  }
  
  def createGuitar(id: Long, neck: Neck, body: Body, head: Head): Guitar = {
    Guitar(id, ModelBuilder.createModel(id, "Guitar", "Fender", Array(neck, body, head)))
  }
  
  def createNeck(id: Long, name: String, price: Double, fret: String, trusRoad: String): Neck = {
    Neck(id, name, price, fret, trusRoad)
  }
  
  def createBody(id: Long, name: String, price: Double, material: String): Body = {
    Body(id, name, price, material)
  }
  
  def createHead(id: Long, name: String, price: Double, tuningKey: String): Head = {
    Head(id, name, price, tuningKey)
  }
  
  def createGuitarFromMap(guitarMap: Map[String, String]): Guitar = {
    val neck = createNeck(guitarMap("neck.id").toLong, guitarMap("neck.name"), guitarMap("neck.price").toDouble, guitarMap("neck.fret"), guitarMap("neck.trusRoad"))
    val body = createBody(guitarMap("body.id").toLong, guitarMap("body.name"), guitarMap("body.price").toDouble, guitarMap("body.material"))
    val head = createHead(guitarMap("head.id").toLong, guitarMap("head.name"), guitarMap("head.price").toDouble, guitarMap("head.tuningKey"))
    createGuitar(guitarMap("id").toLong, neck, body, head)
  }
}
