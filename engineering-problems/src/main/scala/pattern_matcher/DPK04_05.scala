package pattern_matcher

import scala.annotation.tailrec

object DPK04_05 {

  val countries = List(
    ("Usa", "English"),
    ("Brazil", "Portuguese"),
    ("Spain", "Spanish"),
    ("Italy", "Italian"),
    ("France", "French"),
    ("Germany", "German")
  )

  def matchPattern(country: String): String = {

    val result = countries.foldLeft("Unknown") { (acc, pair) =>
      val (k, v) = pair
      if (k == country) v else acc
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
