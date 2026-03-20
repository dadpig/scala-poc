package leadrandori

object FindAnagramsInString {

  def findAnagrams(input: String, word: String): List[Int] = {
    val wordCount = scala.collection.mutable.Map[Char, Int]()
    for (char <- word) {
      wordCount(char) = wordCount.getOrElse(char, 0) + 1
    }

    val result = scala.collection.mutable.ListBuffer[Int]()
    val windowSize = word.length

    for (i <- 0 to input.length - windowSize) {
      val substring = input.substring(i, i + windowSize)
      val substringCount = scala.collection.mutable.Map[Char, Int]()
      for (char <- substring) {
        substringCount(char) = substringCount.getOrElse(char, 0) + 1
      }

      if (wordCount == substringCount) {
        result += i
      }
    }

    result.toList


  }

  def main(args: Array[String]): Unit = {
    val input = "CODESANDBOXCODESANDBOX"
    val word = "SAND"
    val result = findAnagrams(input, word)
    println(s"Anagrams of '$word' in '$input' found at indices: ${result.mkString(", ")}")
  }

}
