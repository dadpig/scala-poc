package tokenizer

object DPK06_04 {

  private def tokenize(input: String, token: String): Array[String] = {
   
       var tokens = List[String]()
    var currentToken = new StringBuilder
    var i = 0
    token.filter(_ => {
      while (i < input.length) {
        if (input.startsWith(token, i)) {
          tokens = tokens :+ currentToken.toString()
          currentToken = new StringBuilder
          i += token.length
        } else {
          currentToken.append(input.charAt(i))
          i += 1
        }
      }
      tokens = tokens :+ currentToken.toString()
      true
    })
    tokens.toArray

  }



  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    println(tokens.mkString("[", ", ", "]"))
  }

}
