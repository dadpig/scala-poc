package guitar.factory.model

case class Guitar(id: Long, model: Model, customization: Specification, year: Int) {
  
  def calculatePrice: Double = {
    model.calculateTotalPrice + customization.totalCustomPrice
  }

  def calculateWeight: Double = {
    model.calculateTotalWeight 
  }
  
  override def toString: String = {
    s"Guitar{id=$id, model=$model, customization=$customization, year=$year}"
  }
}



