package v2.guitar.factory.model

case class Model(id: Long, name: String, brand: String, bodyParts: Array[Part]) {
  
  def calculatePrice: Double = {
    bodyParts.map(_.getPrice).sum
  }
  
  override def toString: String = {
    s"Model{id=$id, name=$name, brand=$brand, bodyParts=${bodyParts.mkString("[", ", ", "]")}}"
  }
}
