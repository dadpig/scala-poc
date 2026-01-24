package lookup

import scala.util.boundary
import scala.util.boundary.break
object DPK03_10 {

  def lookup(map: Map[String, String], key: String): Option[String] = {
    boundary {
      for ((k, v) <- map) {
        if (k == key || v == key) {
          break(Some(v))
        }
      }
      None
    }
  }

  def main(args: Array[String]): Unit = {
    val sampleMap = Map("John" -> "John@internet.com", "Bob" -> "Bob@internet.com", "Charlie" -> "Charlie@internet.com")
    val keyToLookup = "John"
    val result = lookup(sampleMap, keyToLookup)

    result match {
      case Some(name) => println(s"Found: $name")
      case None => println(s"No entry found for key: $keyToLookup")
    }

    //filter for values
    val valueToLookup = "John@internet.com"
    val resultVal = lookup(sampleMap, valueToLookup)
    result match {
      case Some(name) => println(s"Found Value: $name")
      case None => println(s"No entry found for value: $keyToLookup")
    }
  }
}
