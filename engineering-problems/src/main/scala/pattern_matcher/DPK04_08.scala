package pattern_matcher

import scala.util.boundary
import scala.util.boundary.break

object DPK04_08 {

  val countries = List(
    ("Usa", "English"),
    ("Brazil", "Portuguese"),
    ("Spain", "Spanish"),
    ("Italy", "Italian"),
    ("France", "French"),
    ("Germany", "German")
  )

  def matchPattern(country: String): String = {

    boundary {
      for ((key, value) <- countries) {
        if (key == country) {
          break(value)
        }
      }
      "Unknown"
    }
  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
