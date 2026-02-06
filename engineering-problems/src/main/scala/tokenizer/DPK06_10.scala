package tokenizer



object DPK06_10 {

  private def tokenize(input: String, token: String): Array[String] = {

    input.foldRight(List.empty[String]) { (char, acc) =>
      if (acc.isEmpty) {
        List(char.toString)
      } else if (char.toString == token) {
        token :: acc
      } else {
        (char.toString + acc.head) :: acc.tail
      }
    }.toArray
  }


  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    println(tokens.mkString("[", ", ", "]"))
  }

}
