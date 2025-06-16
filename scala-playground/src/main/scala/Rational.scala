class Ratinal(n: Int, d: Int):
  require(d !=0)

  private val g = gcd(n.abs, d.abs) //gds -> greatest common divisor
  val numer = n/g
  val denom = d/g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational = 
    Rational(
      numer * that.denom + that.numer * demon, 
      demon * that.denom
      )

  def * (that: Rational): Rational =
    Rational(numer * that.numer, denom * that.denom)

  private def gcd(a: Int, b: Int): Int =
    if b == 0 then a else gcd(b, a % b)

  override def toString = s"$numer/$denom"


//test
val x = Rational(1,2) // 1/2
val y = Rational(2,3) // 2/3

x + y // 7/6
