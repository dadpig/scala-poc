package com.logisticsystem.business

class Weather(val temperature: Double, 
              val humidity: Double) {

  def isHot: Boolean = temperature > 30.0

  def isStormy: Boolean = humidity > 70.0



  override def toString: String = {
    if (isHot)
      s"Weather(temperature=$temperature, humidity=$humidity) - It's fine!"
    else
      s"Weather(temperature=$temperature, humidity=$humidity) - It's stormy!"
    }


}
