package com.logisticsystem.domain

import com.logisticsystem.business.{GasOil, Weather}

abstract class Transport (val name: String, val distance: Int, val capacity: Int, val price: Double, val gasOil: GasOil, weather: Weather) {

  
  def displayInfo(): String = {
    s"Transport(name=$name, distance=$distance, capacity=$capacity, price=$price, gasOil=$gasOil, weather=$weather)"
  }

  def calculateTransportCost(): Double = {
    val costPerUnit = {
      //logic to calculate cost per unit based on gasOil price and weather conditions
      if (gasOil.isExpensive) {
        if (weather.isStormy) 1.8 * gasOil.price
        else if (weather.isWindy) 1.5 * gasOil.price
        else gasOil.price * 1.2
        
      } else {
        if (weather.isStormy) 1.4 * gasOil.price
        else if (weather.isWindy) gasOil.price * 1.2
        else gasOil.price
      }
    }
    distance * costPerUnit
  }
}
