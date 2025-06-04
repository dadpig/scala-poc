package com.logisticsystem.business

class GasOil (val amount: Int, val price:Double) {

  def isExpensive: Boolean = price > 3.0

  def isAffordable: Boolean = price <= 3.0

  
  override def toString: String = {
    if(isAffordable)
      s"GasOil(amount=$amount, price=$price) - Affordable"
    else
      s"GasOil(amount=$amount, price=$price) - Expensive"
  }
}
