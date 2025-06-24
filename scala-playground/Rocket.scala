class Rocket:
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20

//companion object
object Rocket:
  private def fuel = 10

  def chooseStrategy(rocket: Rocket) = {
    if rocket.canGoHomeAgain then
      goHome()
    else
      pickStar()
  }

  def goHome() = {"Back to Earth"}

  def pickStar() = {"Hi Sun"}
