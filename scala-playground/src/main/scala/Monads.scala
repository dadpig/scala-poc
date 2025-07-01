class Monads:

def parseInt(str: String): Option[Int] =
  scala.util.Try(str.toInt).toOption

def divide(a: Int, b: Int): Option[Int] =
  if(b == 0) None else Some(a / b)


def stringDivideBy(aStr: String, bStr: String): Option[Int] =
  for {
    aNum <- parseInt(aStr)
    bNum <- parseInt(bStr)
    ans  <- divide(aNum, bNum)
  } yield ans

stringDivideBy("6", "2")
// res1: Option[Int] = Some(3)

stringDivideBy("6", "0")
// res2: Option[Int] = None

stringDivideBy("6", "foo")
// res3: Option[Int] = None

stringDivideBy("bar", "2")
// res4: Option[Int] = None
