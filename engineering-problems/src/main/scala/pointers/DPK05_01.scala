package pointers

object DPK05_01 {

  private var leaderboard:scala.collection.mutable.Map[String, Int] = scala.collection.mutable.Map()


  private def powerOfGivenPerson(power: Map[String, Int], name: String): Int = {
    power.getOrElse(name, 0)
  }

  private def checkMostPowerful(power: Map[String, Int], personOne: String, personTwo: String) : String = {
   if powerOfGivenPerson(power, personOne) > powerOfGivenPerson(power, personTwo) then
     personOne
   else if powerOfGivenPerson(power, personOne) < powerOfGivenPerson(power, personTwo) then
     personTwo
   else
     "draw"
  }

  private def play(power: Map[String, Int], personOne: String, personTwo: String): Unit = {
    var result = checkMostPowerful(power, personOne, personTwo)
    if result == "draw" then{
      var currentScore = leaderboard(personOne)
      leaderboard(personOne) = currentScore + 5
      var currentScoreP2 = leaderboard(personTwo)
      leaderboard(personTwo) = currentScoreP2 + 5
    }else if result == personOne then {
      var currentScore = leaderboard(personOne)
      leaderboard(personOne) = currentScore + 10
      var currentScoreP2 = leaderboard(personTwo)
      leaderboard(personTwo) = currentScoreP2 - 5
    }else{
      var currentScore = leaderboard(personOne)
      leaderboard(personOne) =  currentScore - 5
      var currentScoreP2 = leaderboard(personTwo)
      leaderboard(personTwo) = currentScoreP2 + 10
    }
  }

  private def printLeaderBoard(): Unit = {
    println("Leaderboard:")
    leaderboard.toSeq.sortBy(-_._2).foreach { case (name, score) =>
      println(s"$name: $score")
    }
  }

  private def addLeaderBoard(power:Map[String, Int]): Unit = {
    power.keys.foreach { name => leaderboard(name) = 0 }
  }

  def main(args: Array[String]): Unit = {
    val power: Map[String, Int] = Map(
      "John" -> 100,
      "Paul" -> 90,
      "George" -> 80,
      "Ringo"-> 70
    )

    addLeaderBoard(power)
    printLeaderBoard()
    play(power, "John", "Paul")
    printLeaderBoard()
    play(power, "John", "Ringo")
    printLeaderBoard()
  }
}
