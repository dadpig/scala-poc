package leadrandori

object BreadthFirstSearch {
  

    def bfs(graph: Map[Int, List[Int]], start: Int): List[Int] = {
      var visited = Set[Int]()
      var queue = List(start)
      var result = List[Int]()

      while (queue.nonEmpty) {
        val node = queue.head
        queue = queue.tail

        if (!visited.contains(node)) {
          visited += node
          result :+= node
          queue ++= graph.getOrElse(node, Nil).filterNot(visited.contains)
        }
      }

      result
    }

    def main(args: Array[String]): Unit = {
      val graph = Map(
        0 -> List(1, 2),
        1 -> List(0, 3, 4),
        2 -> List(0, 5),
        3 -> List(1),
        4 -> List(1, 5),
        5 -> List(2, 4)
      )

      val startNode = 0
      val bfsResult = bfs(graph, startNode)
      println(s"BFS traversal starting from node $startNode: ${bfsResult.mkString(", ")}")
    }


}
