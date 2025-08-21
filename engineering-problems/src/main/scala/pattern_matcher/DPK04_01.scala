package pattern_matcher

object DPK04_01 {

  def matchPattern(country: String): String = {

    val countries = Map(
      "Usa" -> "English",
      "Brazil" -> "Portuguese",
      "Spain" -> "Spanish",
      "Italy" -> "Italian",
      "France" -> "French",
      "Germany" -> "German"
    )

    countries.getOrElse(country, "Unknown country")

  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
