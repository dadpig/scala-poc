package lookup

object DPK03_01 {

  def lookup(map: Map[Int, String], key: Int): Option[String] = {
    map.get(key)
  }
  def main(args: Array[String]): Unit = {
    val sampleMap = Map(1 -> "John", 2 -> "Bob", 3 -> "Charlie")
    val keyToLookup = 1
    val result = lookup(sampleMap, keyToLookup)

    result match {
      case Some(name) => println(s"Found: $name")
      case None => println(s"No entry found for key: $keyToLookup")
    }
  }

}
