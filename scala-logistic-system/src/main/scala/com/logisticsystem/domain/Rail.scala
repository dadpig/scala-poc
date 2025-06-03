package com.logisticsystem.domain

import com.logisticsystem.business.{GasOil, Weather}

class Rail (name: String, distance: Int, capacity: Int, price: Double, gasOil: GasOil, weather: Weather) extends Transport(name, distance, capacity, price, gasOil, weather) {

}
