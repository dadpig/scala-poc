package tokenizer

object DPK06_02 {

  private def tokenize(input: String, token: String): Array[String] = {
    val tokens = scala.collection.mutable.ArrayBuffer[String]()
    var currentToken = new StringBuilder
    var i = 0
    while (i < input.length) {
      if (input.substring(i).startsWith(token)) {
        tokens += currentToken.toString()
        currentToken = new StringBuilder
        i += token.length
      } else {
        currentToken.append(input.charAt(i))
        i += 1
      }
    }
    tokens += currentToken.toString()
    tokens.toArray
  }


  private def printTokens(tokens: Array[String]): Unit = {
    println(tokens.mkString("[", ", ", "]"))
  }

  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    printTokens(tokens)
  }

}
