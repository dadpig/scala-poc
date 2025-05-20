package model

class Cache {

  val cache = scala.collection.mutable.Map[String, String]()

  def allKeys(): List[String] = {
    cache.keys.toList
  }

  def allValues(): List[String] = {
    cache.values.toList
  }

  def get(key: String): Option[String] = {
    cache.get(key)
  }

  def set(key: String, value: String): Unit = {
    cache.put(key, value)
  }

}
