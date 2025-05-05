package v2.guitar.factory.model

case class Body(id: Long, name: String, price: Double, material: String ) extends Part(id, name, price){
  
}
