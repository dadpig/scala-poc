package leadrandori

object KDimensionalTree {

  case class Node(point: List[Int], left: Node = null, right: Node = null)

  def buildTree(points: List[List[Int]], depth: Int = 0): Node = {
    if (points.isEmpty) return null
    val k = points.head.length
    val axis = depth % k
    val sortedPoints = points.sortBy(_(axis))
    val median = sortedPoints.length / 2
    val node = Node(sortedPoints(median))
    node.copy(left = buildTree(sortedPoints.take(median), depth + 1), right = buildTree(sortedPoints.drop(median + 1), depth + 1))
  }

  def main(args: Array[String]): Unit = {
    val points = List(List(3, 6), List(2, 7), List(17, 15), List(6, 12), List(9, 1), List(2, 3))
    val tree = buildTree(points)
    println(s"K-Dimensional Tree for $points: $tree")
  }

}
