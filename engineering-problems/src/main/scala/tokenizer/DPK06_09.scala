package tokenizer

import scala.util.boundary
import scala.util.boundary.break

object DPK06_09 {

  private def tokenize(input: String, token: String): Array[String] = {
    if (token.isEmpty) {
      Array(input)
    } else {
      val tokens = scala.collection.mutable.ArrayBuffer[String]()
      var start = 0

      boundary {
        for {
          index <- Iterator.iterate(input.indexOf(token, start)) { i =>
            if (i == -1) -1 else input.indexOf(token, i + token.length)
          }
        } {
          if (index == -1) {
            tokens += input.substring(start)
            break()
          } else {
            tokens += input.substring(start, index)
            start = index + token.length
          }
        }
      }

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
