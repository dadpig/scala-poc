package tokenizer

object DPK06_07 {

  private def tokenize(input: String, token: String): Array[String] = {

    if (token.isEmpty) {
      Array(input)
    } else {
      var index = input.indexOf(token)
      var start = 0
      val tokens = scala.collection.mutable.ArrayBuffer[String]()
      while (index != -1) {
        tokens += input.substring(start, index)
        start = index + token.length
        index = input.indexOf(token, start)
      }
      tokens += input.substring(start)
      tokens.toArray
    }
  }



  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    println(tokens.mkString("[", ", ", "]"))
  }

}
