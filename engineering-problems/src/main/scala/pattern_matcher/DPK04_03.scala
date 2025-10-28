package pattern_matcher

import scala.annotation.tailrec

object DPK04_03 {

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
        case (k, v) :: tail =>
          if (k == key) v
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
