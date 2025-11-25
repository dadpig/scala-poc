package tokenizer

import scala.annotation.tailrec

object DPK06_03 {

  private def tokenize(input: String, token: String): Array[String] = {
   
    @tailrec
    def helper(remaining: String, currentToken: StringBuilder, tokens: List[String]): List[String] = {
      if (remaining.isEmpty) {
        tokens :+ currentToken.toString()
      } else if (remaining.startsWith(token)) {
        helper(remaining.substring(token.length), new StringBuilder, tokens :+ currentToken.toString())
      } else {
        currentToken.append(remaining.charAt(0))
        helper(remaining.substring(1), currentToken, tokens)
      }
    }

    helper(input, new StringBuilder, List()).toArray

  }



  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    println(tokens.mkString("[", ", ", "]"))
  }

}
