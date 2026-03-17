package leadrandori



object DoubleLinkedList {
  class Node(var data: Int, var prev: Node, var next: Node)

  var head: Node = null
  var tail: Node = null

  def append(data: Int): Unit = {
    val newNode = new Node(data, null, null)
    if (head == null) {
      head = newNode
      tail = newNode
    } else {
      tail.next = newNode
      newNode.prev = tail
      tail = newNode
    }
  }

  def printList(): Unit = {
    var current = head
    while (current != null) {
      print(current.data + " ")
      current = current.next
    }
    println()
  }




  def main(args: Array[String]): Unit = {
    val list =  DoubleLinkedList
    list.append(1)
    list.append(2)
    list.append(3)
    println("Double Linked List:")
    list.printList()
  }

}
