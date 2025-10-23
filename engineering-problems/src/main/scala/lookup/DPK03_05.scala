package lookup

import scala.annotation.tailrec

object DPK03_05 {

  def lookup(map: Map[String, String], key: String): Option[String] = {
   
    @tailrec
    def recursiveLookup(tuples: List[(String, String)]): Option[String] = {
      tuples match {
        case Nil => None
        case (k, v) :: tail =>
          if (k.equals(key) || v.equals(key)) Some(v)
          else recursiveLookup(tail)
      }
    }
    recursiveLookup(map.toList)
  }

  def main(args: Array[String]): Unit = {
    val sampleMap = Map("John" -> "John@internet.com", "Bob"-> "Bob@internet.com", "Charlie" -> "Charlie@internet.com")
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
