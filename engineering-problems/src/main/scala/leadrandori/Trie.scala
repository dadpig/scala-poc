package leadrandori
import util.boundary, boundary.break

object Trie {

  private val allLowerLetters = 26
  private val firstChar = 'a'
  private val root = TrieNode(Array.fill(allLowerLetters)(None), false)

  case class TrieNode(children: Array[Option[TrieNode]], var isEndOfWord: Boolean)

  private def insert(root: TrieNode, word: String): Unit = {
    var currentNode = root
    for (char <- word) {
      val index = char - firstChar
      if (currentNode.children(index).isEmpty) {
        currentNode.children(index) = Some(TrieNode(Array.fill(allLowerLetters)(None), false))
      }
      currentNode = currentNode.children(index).get
    }
    currentNode.isEndOfWord = true
  }

  private def search(root: TrieNode, word: String): Boolean = {
    boundary {
      var currentNode = root
      for (char <- word) {
        val index = char - firstChar
        if (currentNode.children(index).isEmpty) {
          break(false)
        }
        currentNode = currentNode.children(index).get
      }
      break(currentNode.isEndOfWord)
    }
  }

  def main(args: Array[String]): Unit = {
    insert(root, "hello")
    insert(root, "scala")

    println(s"Search for 'hello': ${search(root, "hello")}")
    println(s"Search for 'world': ${search(root, "world")}")

  }

}
