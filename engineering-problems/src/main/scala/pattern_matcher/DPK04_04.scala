package pattern_matcher

import scala.annotation.tailrec

object DPK04_04 {

  val countries = List(
    ("Usa", "English"),
    ("Brazil", "Portuguese"),
    ("Spain", "Spanish"),
    ("Italy", "Italian"),
    ("France", "French"),
    ("Germany", "German")
  )

  def matchPattern(country: String): String = {
    
    for ((key, value) <- countries) {
      if (key == country) {
        return value
      }
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
