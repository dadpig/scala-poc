package com.logisticsystem.business

import com.logisticsystem.domain.Transport

class EstimatePrice {

  def estimate(transport: Transport, weather: Weather, gasOil: GasOil): Double = {
    val updatedTransport = transport.copy(weather = weather, gasOil = gasOil)
    updatedTransport.calculateTransportCost()
  }
}
