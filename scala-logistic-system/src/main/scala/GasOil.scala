class GasOil (val price:Double) {

  def isExpensive: Boolean = price > 3.0

  def isAffordable: Boolean = price <= 3.0

  override def toString: String = {
    s"GasOil(price=$price)"
  }
}
