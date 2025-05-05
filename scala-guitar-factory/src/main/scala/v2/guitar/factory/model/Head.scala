package v2.guitar.factory.model

case class Head(id: Long, name: String, price: Double, tuningKey: String) extends Part(id, name, price){

}
