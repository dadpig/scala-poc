package tokenizer

object DPK06_01 {

  private def tokenize(input: String, token: String): Array[String] = {
    input.split(token)
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
