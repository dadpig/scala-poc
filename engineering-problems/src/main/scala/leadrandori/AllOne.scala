package leadrandori

object AllOne {


  class Node(var count: Int, var keys: Set[String], var prev: Node, var next: Node)

  var head: Node = new Node(0, Set.empty, null, null)
  var tail: Node = head
  val keyToNode: scala.collection.mutable.Map[String, Node] = scala.collection.mutable.Map.empty

  def increment(key: String): Unit = {
    val currentNode = keyToNode.getOrElse(key, head)
    val newCount = currentNode.count + 1
    var nextNode = currentNode.next

    if (nextNode == null || nextNode.count != newCount) {
      nextNode = new Node(newCount, Set.empty, currentNode, nextNode)
      if (currentNode.next != null) currentNode.next.prev = nextNode
      currentNode.next = nextNode
      if (tail == currentNode) tail = nextNode
    }
    nextNode.keys += key
    keyToNode(key) = nextNode

    if (currentNode != head) {
      currentNode.keys -= key
      if (currentNode.keys.isEmpty) remove(currentNode)
    }
  }

  def decrement(key: String): Unit = {
    if (!keyToNode.contains(key)) return
    val currentNode = keyToNode(key)
    val newCount = currentNode.count - 1
    var prevNode = currentNode.prev

    if (newCount > 0) {
      if (prevNode == null || prevNode.count != newCount) {
        prevNode = new Node(newCount, Set.empty, prevNode, currentNode)
        if (currentNode.prev != null) currentNode.prev.next = prevNode
        currentNode.prev = prevNode
        if (head == currentNode) head = prevNode
      }
      prevNode.keys += key
      keyToNode(key) = prevNode
    } else {
      keyToNode -= key
    }

    currentNode.keys -= key
    if (currentNode.keys.isEmpty) remove(currentNode)
  }


  def remove(node: Node): Unit = {
    if (node.prev != null) node.prev.next = node.next
    if (node.next != null) node.next.prev = node.prev
    if (head == node) head = node.next
    if (tail == node) tail = node.prev
  }

  def main(args: Array[String]): Unit = {
    increment("hello")
    increment("hello")
    increment("world")
    println(s"head: ${head.count}, keys: ${head.keys}")
    println(s"tail: ${tail.count}, keys: ${tail.keys}")
    decrement("hello")
    println(s"head: ${head.count}, keys: ${head.keys}")
    println(s"tail: ${tail.count}, keys: ${tail.keys.mkString(", ")}")

  }

}
