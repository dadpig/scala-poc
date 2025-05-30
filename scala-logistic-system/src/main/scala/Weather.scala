class Weather(val temperature: Double, 
              val humidity: Double, 
              val windSpeed: Double) {

  def isHot: Boolean = temperature > 30.0

  def isHumid: Boolean = humidity > 70.0

  def isWindy: Boolean = windSpeed > 20.0

  override def toString: String = {
    s"Weather(temperature=$temperature, humidity=$humidity, windSpeed=$windSpeed)"
  }

}
