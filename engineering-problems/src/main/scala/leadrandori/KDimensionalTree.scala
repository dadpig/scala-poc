package leadrandori

object KDimensionalTree {

  case class Node(point: List[Int], left: Node = null, right: Node = null)

  def buildTree(points: List[List[Int]], depth: Int = 0): Node = {
    if (points.isEmpty) return null
    val dimension = points.head.length
    val axis = depth % dimension
    val sortedPoints = points.sortBy(_(axis))
    val median = sortedPoints.length / 2
    val node = Node(sortedPoints(median))
    node.copy(left = buildTree(sortedPoints.take(median), depth + 1), right = buildTree(sortedPoints.drop(median + 1), depth + 1))
  }


  private def printTree(node: Node, depth: Int = 0): Unit = {
    if (node != null) {
      printTree(node.left, depth + 1)
      println(" | " * depth * 2 + s"Depth $depth: ${node.point}")
      printTree(node.right, depth + 1)
    }
  }


  private def addNode(root: Node, point: List[Int], depth: Int = 0): Node = {
    if (root == null) return Node(point)
    val dimension = point.length
    val axis = depth % dimension
    if (point(axis) < root.point(axis)) {
      root.copy(left = addNode(root.left, point, depth + 1))
    } else {
      root.copy(right = addNode(root.right, point, depth + 1))
    }
  }

  private def removeNode(root: Node, point: List[Int], depth: Int = 0): Node = {
    if (root == null) return null
    val dimension = point.length
    val axis = depth % dimension
    if (root.point == point) {
      if (root.right != null) {
        val minNode = findMin(root.right, axis, depth + 1)
        root.copy(point = minNode.point, right = removeNode(root.right, minNode.point, depth + 1))
      } else {
        root.left
      }
    } else if (point(axis) < root.point(axis)) {
      root.copy(left = removeNode(root.left, point, depth + 1))
    } else {
      root.copy(right = removeNode(root.right, point, depth + 1))
    }
  }


  private def findMin(node: Node, axis: Int, depth: Int): Node = {
    if (node == null) return null
    val point = depth % node.point.length
    if (point == axis) {
      if (node.left == null) return node
      findMin(node.left, axis, depth + 1)
    } else {
      val leftMin = findMin(node.left, axis, depth + 1)
      val rightMin = findMin(node.right, axis, depth + 1)
      List(node, leftMin, rightMin).filter(_ != null).minBy(_.point(axis))
    }
  }

  def main(args: Array[String]): Unit = {
    val points = List(List(3, 6), List(2, 7), List(17, 15), List(6, 12), List(9, 1), List(2, 3))
    val tree = buildTree(points)
    println("K-Dimensional Tree:")
    printTree(tree)

    val newPoint = List(5, 5)
    val updatedTree = addNode(tree, newPoint)
    println("\nAfter adding point (5, 5):")
    printTree(updatedTree)

    val removedTree = removeNode(updatedTree, List(2, 7))
    println("\nAfter removing point (2, 7):")
    printTree(removedTree)
  }



}
