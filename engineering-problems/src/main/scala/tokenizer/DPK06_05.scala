package tokenizer

object DPK06_05 {

  private def tokenize(input: String, token: String): Array[String] = {
    val result = for {
      segment <- input.split(",")
    } yield segment
    result
  }



  def main(args: Array[String]): Unit = {
    val input = "Hello,World,This,Is,Scala"
    val token = ","
    val tokens = tokenize(input, token)
    println(tokens.mkString("[", ", ", "]"))
  }

}
