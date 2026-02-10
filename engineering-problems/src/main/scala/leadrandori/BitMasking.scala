package leadrandori

object BitMasking {

  private def masking(n: Int): Int = {
    var result = 0
    var i = 0
    while (i < n) {
      print(s"Setting bit at position $i & "+(1 << i)+"  ")
      result |= (1 << i) 
      i += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val n = List(0, 1, 2, 3, 4, 5)
    for (num <- n) {
      val result = masking(num)
      println(s"Bitmasking result for n=$num: $result")
    }
  }

}
