package com.system.domain

import org.scalatest.funsuite.AnyFunSuite

import scala.collection.mutable


class RestaurantTest extends AnyFunSuite {

  test("List Available Dishes") {
    val restaurant = Restaurant(mutable.Queue[Dish]().empty)
    //assert available dishes from restaurant
    assert(restaurant.availableDishes() == List(Dish("Pizza", 10.0, 30), 
                                              Dish("Pasta", 8.0, 20), 
                                                Dish("Burger", 5.0, 15), 
                                                  Dish("Salad", 4.0, 10), 
                                                    Dish("Soup", 3.0, 5)))

  }

  test("Time to prepare next Dish when queue is empty") {
    val restaurant = Restaurant(mutable.Queue[Dish]().empty)
    //assert timeToServeNextDish when queue is empty
    assert(restaurant.timeToServeNextDish() == 0)
  }

  test("Time to prepare next Dish when queue Salad ") {
    val restaurant = Restaurant(mutable.Queue[Dish]().empty)
    restaurant.addDishToQueue("Salad")
    assert(restaurant.timeToServeNextDish() == 10)
  }

  test("Time to prepare next Dish when queue 3 Salad ") {
    val restaurant = Restaurant(mutable.Queue[Dish]().empty)
    restaurant.addDishToQueue("Salad")
    restaurant.addDishToQueue("Salad")
    restaurant.addDishToQueue("Salad")
    assert(restaurant.timeToServeNextDish() == 30)
  }


  test("Time to prepare next Dish when all dishes in queue") {
    val restaurant = Restaurant(mutable.Queue[Dish]().empty)
    restaurant.addDishToQueue("Pizza")
    restaurant.addDishToQueue("Pasta")
    restaurant.addDishToQueue("Burger")
    restaurant.addDishToQueue("Salad")
    restaurant.addDishToQueue("Soup")
    assert(restaurant.timeToServeNextDish() == 80)
  }
}
