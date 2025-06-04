package com.logisticsystem.domain

import com.logisticsystem.business.{GasOil, Weather}

class Truck(name: String, distance: Int, capacity: Int, price: Double, gasOil: GasOil, weather: Weather) extends Transport(name, distance, capacity, price, gasOil, weather) {

  def reachMaxCapacity: Boolean = capacity < 2000

  def minCapacity: Boolean = capacity > 1

}
