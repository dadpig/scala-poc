package com.logisticsystem.domain

import com.logisticsystem.business.GasOil

class Truck(name: String, distance: Int, capacity: Int, price: Double, gasOil: GasOil) extends Transport(name, distance, capacity, price, gasOil) {

}
