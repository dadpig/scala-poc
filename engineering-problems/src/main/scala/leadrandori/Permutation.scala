package leadrandori

object Permutation {

  def permuteIntegers(nums: List[Int]): List[List[Int]] = {

    def backtrack(start: Int, end: Int, current: List[Int], result: List[List[Int]]): List[List[Int]] = {
      if (start == end) {
        current :: result
      } else {
        var newResult = result
        for (i <- start until end) {
          val swapped = current.updated(start, current(i)).updated(i, current(start))
          newResult = backtrack(start + 1, end, swapped, newResult)
        }
        newResult
      }
    }

    backtrack(0, nums.length, nums, Nil)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3)
    val result = permuteIntegers(input)
    println(s"Permutations of $input: $result")
  }


}
