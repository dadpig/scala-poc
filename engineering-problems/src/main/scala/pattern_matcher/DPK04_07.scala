package pattern_matcher

import scala.annotation.tailrec

object DPK04_07 {

  val countries = List(
    ("Usa", "English"),
    ("Brazil", "Portuguese"),
    ("Spain", "Spanish"),
    ("Italy", "Italian"),
    ("France", "French"),
    ("Germany", "German")
  )

  def matchPattern(country: String): String = {
    var counter = 0
    while (counter < countries.length) {
      val (key, value) = countries(counter)
      if (key == country) {
        return value
      }
      counter = counter + 1
    }
    "Unknown"
  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
