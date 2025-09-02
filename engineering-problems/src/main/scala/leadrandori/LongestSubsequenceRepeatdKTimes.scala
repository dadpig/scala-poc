package leadrandori

object LongestSubsequenceRepeatdKTimes {
  // Function to find the longest subsequence that repeats k times
  def longestSubsequenceKTimes(s: String, k: Int): String = {
    val n = s.length
    var longestSubseq = ""
    for (i <- 0 until n) {
      for (j <- i + 1 to n) {
        val subseq = s.substring(i, j)
        val count = s.sliding(subseq.length).count(_ == subseq)
        if (count >= k && subseq.length > longestSubseq.length) {
          longestSubseq = subseq
        }
      }
    }
    longestSubseq
  }

  def main(args: Array[String]): Unit = {
    val input = "letsletscodelets"
    val k = 3
    val result = longestSubsequenceKTimes(input, k)
    println(s"Longest subsequence that repeats $k times: $result")
  }
}