package v2.guitar.factory.model

case class Guitar(id: Long, model: Model) {
  
  def calculatePrice: Double = {
    model.calculatePrice
  }

 
  override def toString: String = {
    s"Guitar{id=$id, model=$model}"
  }
}


