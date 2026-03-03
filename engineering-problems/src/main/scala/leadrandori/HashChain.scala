package leadrandori

object HashChain {

  def hashChain(n: BigInt): List[BigInt] = {
    if (n <= 0) Nil
    else if (n == 1) List(1)
    else {
      val previous = hashChain(n - 1)
      val newHash = previous.last * 31 + n
      previous :+ newHash
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    val result = hashChain(n)
    println(s"Hash chain of n = $n: $result")
  }

}
