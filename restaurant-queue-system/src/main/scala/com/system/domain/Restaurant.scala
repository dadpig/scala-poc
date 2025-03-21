package com.system.domain

import scala.collection.mutable


case class Restaurant(queue: mutable.Queue[Dish]) {

  def addDishToQueue(dish: Dish): Unit = {
    this.queue.enqueue(dish)
  }
  
  def timeToServeNextDish(): Int = {
    this.queue.map(_.timeToServe()).sum
  }

  def availableDishes(): List[Dish] = {
    List(
      Dish("Pizza", 10.0, 30),
      Dish("Pasta", 8.0, 20),
      Dish("Burger", 5.0, 15),
      Dish("Salad", 4.0, 10),
      Dish("Soup", 3.0, 5)
    )
  }
  
  def addDishToQueue(dishName: String): Unit = {
    dishName match {
      case "Pizza" => this.queue.enqueue(Dish("Pizza", 10.0, 30))
      case "Pasta" => this.queue.enqueue(Dish("Pasta", 8.0, 20))
      case "Burger" => this.queue.enqueue(Dish("Burger", 5.0, 15))
      case "Salad" => this.queue.enqueue(Dish("Salad", 4.0, 10))
      case "Soup" => this.queue.enqueue(Dish("Soup", 3.0, 5))
    }
  }

  def removeDish(): Unit = {
    this.queue.dequeue._1
  }

}


