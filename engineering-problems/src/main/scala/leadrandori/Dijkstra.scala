package leadrandori

object Dijkstra {

  def solve(graph: Array[Array[Int]], start: Int): Array[Int] = {
    val size = graph.length
    val distances = Array.fill(size)(Int.MaxValue)
    val visited = Array.fill(size)(false)

    distances(start) = 0

    for (_ <- 0 until size) {
      val lessDistance = (0 until size).filterNot(visited).minBy(distances)
      visited(lessDistance) = true

      for (nextDistance <- 0 until size) {
        if (graph(lessDistance)(nextDistance) != 0 && !visited(nextDistance)) {
          val alt = distances(lessDistance) + graph(lessDistance)(nextDistance)
          if (alt < distances(nextDistance)) {
            distances(nextDistance) = alt
          }
        }
      }
    }

    distances
  }

  def main(args: Array[String]): Unit = {
    val graph = Array(
      Array(0, 1, 4, 0, 0, 0),
      Array(1, 0, 4, 2, 7, 0),
      Array(4, 4, 0, 3, 5, 0),
      Array(0, 2, 3, 0, 4, 6),
      Array(0, 7, 5, 4, 0, 7),
      Array(0, 0, 0, 6, 7, 0)
    )

    val startNode = 0
    val shortestPaths = solve(graph, startNode)
    println(s"all path graph ${graph.map(_.mkString(", ")).mkString("\n")}")
    println(s"Shortest paths from node $startNode: ${shortestPaths.mkString(", ")}")
  }

}
