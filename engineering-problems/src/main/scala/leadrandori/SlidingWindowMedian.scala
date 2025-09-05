package leadrandori

object SlidingWindowMedian {

  /*
  The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
   */

  def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {
    if (nums.isEmpty || k == 0) return Array()

    val result = new Array[Double](nums.length - k + 1)
    val window = scala.collection.mutable.SortedSet[Int]()

    for (i <- nums.indices) {
      window.add(nums(i))
      if (i >= k) {
        window.remove(nums(i - k))
      }
      if (i >= k - 1) {
        val sortedWindow = window.toArray
        if (k % 2 == 0) {
          result(i - k + 1) = (sortedWindow(k / 2 - 1) + sortedWindow(k / 2)) / 2.0
        } else {
          result(i - k + 1) = sortedWindow(k / 2).toDouble
        }
      }
    }

    result

  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    val result = medianSlidingWindow(nums, k)
    println(s"Sliding window medians: ${result.mkString(", ")}")
  }
}
