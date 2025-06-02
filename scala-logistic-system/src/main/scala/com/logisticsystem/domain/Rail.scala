package com.logisticsystem.domain

import com.logisticsystem.business.GasOil

class Rail (name: String, distance: Int, capacity: Int, price: Double, gasOil: GasOil) extends Transport(name, distance, capacity, price, gasOil) {

}
