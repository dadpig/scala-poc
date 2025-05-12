class Cache {
  // A simple in-memory key-value store
  // In a real-world application, this would be replaced with a more robust solution
  memory: Map[String, String] = Map()

  def get(key: String): Option[String] = {
    memory.get(key)
  }

  def set(key: String, value: String): Unit = {
    memory += (key -> value)
  }

  def delete(key: String): Unit = {
    memory -= key
  }

  def clear(): Unit = {
    memory = Map()
  }

  def allKeys(): List[String] = {
    memory.keys.toList
  }

  def allValues(): List[String] = {
    memory.values.toList
  }

}