package com.logisticsystem.domain

import com.logisticsystem.business.{GasOil, Weather}

abstract class Transport (val name: String, val distance: Int, val capacity: Int, val price: Double, val gasOil: GasOil, val weather: Weather) {

  
  def displayInfo(): String = {
    s"Transport(name=$name, distance=$distance, capacity=$capacity, price=$price, gasOil=$gasOil, weather=$weather)"
  }

  def calculateTransportCost(): Double = {
    val costPerUnit = {
      if (gasOil.isExpensive) {
        if (weather.isStormy) 1.8 * gasOil.price
        else 1.2 * gasOil.price
      } else {
        if (weather.isStormy) 1.4 * gasOil.price
        else gasOil.price
      }
    }

    distance * costPerUnit + price
  }

  def buildProperTransport(): Transport = {
    if (capacity < 2000) {
      new Truck(name, distance, capacity, price, gasOil, weather)
    } else if (capacity < 10000) {
      new Boat(name, distance, capacity, price, gasOil, weather)
    } else {
      new Rail(name, distance, capacity, price, gasOil, weather)
    }
  }
}
