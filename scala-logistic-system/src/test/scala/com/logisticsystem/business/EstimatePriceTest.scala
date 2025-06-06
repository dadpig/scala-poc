package com.logisticsystem.business

import com.logisticsystem.domain.{Boat, Rail, Truck}
import org.scalatest.funsuite.AnyFunSuite

case class EstimatePriceTest() extends AnyFunSuite{


  test("TEST: Estimate price of a truck in regular weather with affordable gas oil") {
    val affordableGasOil = GasOil(100, 2.5)
    val regularDay = Weather(30, 50)

    val truck: Truck = new Truck("TestTruck", 1000, 10, 5, affordableGasOil, regularDay)
    println("TestTruck affordable gas: price " + truck.calculateTransportCost())
    assert(truck.calculateTransportCost() == truck.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a truck in regular weather with not affordable gas oil") {
    val affordableGasOil = GasOil(100, 3.5)
    val regularDay = Weather(30, 50)

    val truck: Truck = new Truck("TestTruck", 1000, 10, 5, affordableGasOil, regularDay)
    println("TestTruck not affordable gas : price "+  truck.calculateTransportCost())
    assert(truck.calculateTransportCost() == truck.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a truck in stormy weather with affordable gas oil") {
    val affordableGasOil = GasOil(100, 2.5)
    val regularDay = Weather(30, 75)

    val truck: Truck = new Truck("TestTruck", 1000, 10, 5, affordableGasOil, regularDay)
    println("TestTruck stormy affordable gas: price " + truck.calculateTransportCost())
    assert(truck.calculateTransportCost() == truck.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a truck in stormy weather with not affordable gas oil") {
    val affordableGasOil = GasOil(100, 3.5)
    val regularDay = Weather(30, 75)

    val truck: Truck = new Truck("TestTruck", 1000, 10, 5, affordableGasOil, regularDay)
    println("TestTruck stormy not affordable gas : price " + truck.calculateTransportCost())
    assert(truck.calculateTransportCost() == truck.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a Boat in regular weather with affordable gas oil") {
    val affordableGasOil = GasOil(1000, 2.5)
    val regularDay = Weather(30, 50)

    val boat: Boat = new Boat("TestBoat", 5000, 100, 5000, affordableGasOil, regularDay)
    println("TestBoat affordable gas: price " + boat.calculateTransportCost())
    assert(boat.calculateTransportCost() == boat.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a Boat in regular weather with not affordable gas oil") {
    val affordableGasOil = GasOil(1000, 3.5)
    val regularDay = Weather(30, 50)

    val boat: Boat = new Boat("TestBoat", 5000, 100, 5000, affordableGasOil, regularDay)
    println("TestBoat not affordable gas: price " + boat.calculateTransportCost())
    assert(boat.calculateTransportCost() == boat.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a Boat in stormy weather with affordable gas oil") {
    val affordableGasOil = GasOil(1000, 2.5)
    val stormyDay = Weather(30, 75)

    val boat: Boat = new Boat("TestBoat", 5000, 100, 5000, affordableGasOil, stormyDay)
    println("TestBoat stormy affordable gas: price " + boat.calculateTransportCost())
    assert(boat.calculateTransportCost() == boat.copy(gasOil = affordableGasOil, weather = stormyDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a Boat in stormy weather with not affordable gas oil") {
    val affordableGasOil = GasOil(1000, 3.5)
    val stormyDay = Weather(30, 75)

    val boat: Boat = new Boat("TestBoat", 5000, 100, 5000, affordableGasOil, stormyDay)
    println("TestBoat stormy affordable gas: price " + boat.calculateTransportCost())
    assert(boat.calculateTransportCost() == boat.copy(gasOil = affordableGasOil, weather = stormyDay).calculateTransportCost())

  }


  test("TEST: Estimate price of a Rail in regular weather with affordable gas oil") {
    val affordableGasOil = GasOil(5000, 2.5)
    val regularDay = Weather(30, 50)

    val rail: Rail = new Rail("TestRail", 50000, 100000, 2000, affordableGasOil, regularDay)
    println("TestRail affordable gas: price " + rail.calculateTransportCost())
    assert(rail.calculateTransportCost() == rail.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }
  test("TEST: Estimate price of a Rail in regular weather with not affordable gas oil") {
    val affordableGasOil = GasOil(5000, 3.5)
    val regularDay = Weather(30, 50)

    val rail: Rail = new Rail("TestRail", 50000, 100000, 2000, affordableGasOil, regularDay)
    println("TestRail not affordable gas: price " + rail.calculateTransportCost())
    assert(rail.calculateTransportCost() == rail.copy(gasOil = affordableGasOil, weather = regularDay).calculateTransportCost())

  }

  test("TEST: Estimate price of a Rail in stormy weather with affordable gas oil") {
    val affordableGasOil = GasOil(5000, 2.5)
    val stormyDay = Weather(30, 75)

    val rail: Rail = new Rail("TestRail", 50000, 100000, 2000, affordableGasOil, stormyDay)
    println("TestRail in stormy day affordable gas: price " + rail.calculateTransportCost())
    assert(rail.calculateTransportCost() == rail.copy(gasOil = affordableGasOil, weather = stormyDay).calculateTransportCost())

  }
  test("TEST: Estimate price of a Rail in stormy weather with not affordable gas oil") {
    val affordableGasOil = GasOil(5000, 3.5)
    val stormyDay = Weather(30, 75)

    val rail: Rail = new Rail("TestRail", 50000, 100000, 2000, affordableGasOil, stormyDay)
    println("TestRail in stormy day not affordable gas: price " + rail.calculateTransportCost())
    assert(rail.calculateTransportCost() == rail.copy(gasOil = affordableGasOil, weather = stormyDay).calculateTransportCost())

  }

}
