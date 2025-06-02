package com.logisticsystem.domain

import com.logisticsystem.business.{GasOil, Weather}

import scala.annotation.targetName

class Boat(name: String, distance: Int, capacity: Int, price: Double, gasOil: GasOil, weather: Weather) extends Transport(name, distance, capacity, price, gasOil) {


  def reachMaxCapacity: Boolean = capacity < 10000

  def minCapacity: Boolean = capacity > 2000


  
