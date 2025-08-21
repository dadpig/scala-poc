package pattern_matcher

object DPK04 {

  def matchPattern(country: String): String = {
    country match {
      case "Usa" => "English"
      case "Brazil" => "Portuguese"
      case "Spain" => "Spanish"
      case "Italy" => "Italian"
      case "France" => "French"
      case "Germany" => "German"
      case _ => "Unknown country"
    }
  }

  def main(args: Array[String]): Unit = {
    val countries = List("Usa", "Brazil", "Spain", "Italy", "France", "Germany", "Unknown")
    countries.foreach { country =>
      println(s"$country -> ${matchPattern(country)}")
    }
  }

}
