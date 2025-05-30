import scala.annotation.targetName

class Boat(name: String, speed: Int, capacity: Int, price: Double) extends Transport(name, speed, capacity, price) {

  
  def reachMaxCapacity: Boolean = capacity < 10000

  def minCapacity: Boolean = capacity > 2000
}
