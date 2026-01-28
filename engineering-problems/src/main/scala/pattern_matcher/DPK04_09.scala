package pattern_matcher

import scala.annotation.tailrec
import scala.util.boundary
import scala.util.boundary.break

object DPK04_09 {

  val countries = List(
    ("Usa", "English"),
    ("Brazil", "Portuguese"),
    ("Spain", "Spanish"),
    ("Italy", "Italian"),
    ("France", "French"),
    ("Germany", "German")
  )

  def matchPattern(country: String): String = {

    @tailrec
    def lookup(countries: List[(String, String)], key: String): String = {
      countries match {
        case Nil => "Unknown"
        case (mapkey, value) :: tail =>
          if ( mapkey == key) mapkey
          else lookup(tail, key)
      }
    }

    lookup(countries, country)

  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
