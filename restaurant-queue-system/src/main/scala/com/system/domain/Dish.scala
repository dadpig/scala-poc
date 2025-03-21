package com.system.domain

case class Dish(name: String, price: Double, timeTaken: Int) {

  def createDish(name: String, price: Double, timeTaken: Int): Dish = {
    Dish(name, price, timeTaken)
  }

  def getName(): String = {
    name
  }
  
  def timeToServe(): Int = {
    timeTaken
  }
}
