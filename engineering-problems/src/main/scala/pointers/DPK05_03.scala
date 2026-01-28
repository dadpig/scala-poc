package pointers

object DPK05_03 {

  private val leaderboard: scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()

  private def powerOfGivenPerson(power: Map[String, Int], name: String): Int = {
    power.getOrElse(name, 0)
  }

  private def checkMostPowerful(power: Map[String, Int], personOne: String, personTwo: String): String = {
    val personOnePower = powerOfGivenPerson(power, personOne)
    val personTwoPower = powerOfGivenPerson(power, personTwo)
    if personOnePower > personTwoPower then
      personOne
    else if personOnePower < personTwoPower then
      personTwo
    else
      "draw"
  }

  private def play(power: Map[String, Int], personOne: String, personTwo: String): Unit = {
    val name1 = personOne
    val name2 = personTwo
    val score1 = leaderboard(name1)
    val score2 = leaderboard(name2)
    val result = checkMostPowerful(power, name1, name2)
    result match {
      case "draw" =>
        leaderboard(name1) = score1 + 5
        leaderboard(name2) = score2 + 5
      case winner if winner == name1 =>
        leaderboard(name1) = score1 + 10
        leaderboard(name2) = score2 - 5
      case _ =>
        leaderboard(name1) = score1 - 5
        leaderboard(name2) = score2 + 10
    }
  }

  private def printLeaderBoard(): Unit = {
    println("Leaderboard:")
    leaderboard.toSeq.sortBy(-_._2).foreach { case (name, score) =>
      println(s"$name: $score")
    }
  }

  def main(args: Array[String]): Unit = {
    val power: Map[String, Int] = Map(
      "John" -> 100,
      "Paul" -> 90,
      "George" -> 80,
      "Ringo" -> 70
    )

    power.keys.foreach { name => leaderboard(name) = 0 }
    printLeaderBoard()
    play(power, "John", "Paul")
    printLeaderBoard()
    play(power, "John", "Ringo")
    printLeaderBoard()
  }
}