abstract class Transport (val name: String, val speed: Int, val capacity: Int, val price: Double) {

  
  def displayInfo(): String = {
    s"Transport Name: $name, Speed: $speed km/h, Capacity: $capacity passengers, Price: $$price"
  }

}
