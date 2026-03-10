package leadrandori

object Knapsack {

  def knapsack(weights: List[Int], values: List[Int], capacity: Int): Int = {
    val n = weights.length
    val pockets = Array.ofDim[Int](n + 1, capacity + 1)

    for (i <- 1 to n) {
      for (w <- 0 to capacity) {
        if (weights(i - 1) <= w) {
          pockets(i)(w) = math.max(pockets(i - 1)(w), pockets(i - 1)(w - weights(i - 1)) + values(i - 1))
        } else {
          pockets(i)(w) = pockets(i - 1)(w)
        }
      }
    }

    pockets(n)(capacity)
  }

  def main(args: Array[String]): Unit = {
    val weights = List(2, 3, 4, 5)
    val values = List(3, 4, 5, 6)
    val capacity = 5
    val result = knapsack(weights, values, capacity)
    println(s"Maximum value in Knapsack with capacity $capacity: $result")
  }

}
