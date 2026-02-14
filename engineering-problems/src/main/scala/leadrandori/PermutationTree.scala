package leadrandori

object PermutationTree {

  var left: Node = _
  var right: Node = _

  case class Node(value: Int, left: Node = null, right: Node = null)

  def buildTree(nums: List[Int]): Node = {
    if (nums.isEmpty) return null
    val mid = nums.length / 2
    val node = Node(nums(mid))
    node.copy(left = buildTree(nums.take(mid)), right = buildTree(nums.drop(mid + 1)))
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val tree = buildTree(input)
    println(s"Permutation Tree for $input: $tree")
  }


}
