package leadrandori

object MagicOne {

  def solve(value: Long): Int = {
    println(s"current magic number ${value}")
    if (value == 1){
      value.intValue
    }else if (value % 2 == 0){
      solve (value/2)
    }else{
      solve ((value*3) + 1)}
  }

  def main(args: Array[String]): Unit = {
    solve(9223372036854L)
  }

}
