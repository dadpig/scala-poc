import FilterTest.filter

@main
def main(): Unit = {
  println("Hello world!")

  val y = 1 // val is immutable
  var x = 5 // var is mutable

  println("y = " + y)
  println("x = " + x)
  x = x + y
  println("x = " + x)

  println("f_double(" + x + ") = " + f_double(x))
  println("f_multi(" + x + ") = " + f_multi(x))
  println("f_lazy_multi(" + x + ") = " + f_lazy_multi(x))
  println("f_counter_loop(" + x + ") = " + f_counter_loop(x))
  println("f_counter_loop_double(" + x + ") = " + f_counter_loop_double(x))


  List(1, 2, 3, 4, 5).foreach(print)

  println("f_loop_filter(3, List(1, 2, 3, 4, 5)) = " + f_loop_filter(3, List(1, 2, 3, 4, 5)))
  println("f_loop_slice(3, List(1, 2, 3, 4, 5)) = " + f_loop_slice(3, List(1, 2, 3, 4, 5)))

  def f_double(x: Int): Int = {
    x + x
  }

  type R = Double // type alias

  def f_multi(x: R): R = x * x // function f_multi(x) = x^2 using alias R == Double type

  def f_lazy_multi(x: => R): R = x * x //

  def f_counter_loop(n: Int): Int = (1 to n).sum

  def f_counter_loop_double(n: Int): Int = (1 to n).map(_ * 2).sum

  def f_loop_filter(item: Int, list: List[Int]): List[Int] = list.filter(_ == item)

  def f_loop_slice(item: Int, list: List[Int]): List[Int] = list.filter(_ > item)

  def compose(g: R => R, h: R => R) = //need better comprehension here
    println("g=" + g + "   h=" + h)
    (x: R) => g(h(x))

  val f = compose(_ * 2, _ - 1)
  println("f(5) = " + f(5))


  val zscore = // measure how many standard deviations a data point is from the mean of a distribution
    (mean: R, sd: R) => // formula is (x - mean) / sd
      (x: R) =>
        (x - mean) / sd //resulting in standard deviation
  /*
z = ( x - μ ) / σ
Where:

z = Z-score
x = the value being evaluated
μ = the mean
σ = the standard deviation
*/

  println("zscore(5, 7) (6) = " + zscore(5, 7)(6))

  def sugar_zscore(mean: R, sd: R)(x: R) = (x - mean) / sd

  val normer = sugar_zscore(7, 0.4) _ // to be used later using _ as anonymous parameter

  println("normer(6) = " + normer(6)) //nice way to hide things

  val pt = new Point(1, 2)
  println(pt)
  pt.move(10, 10)
  println(pt)

  val p1 = new Point(2, 3)
  val p2 = new Point(2, 4)
  val p3 = new Point(3, 3)
  val p4 = new Point(2, 3)

  println(p1.isSimilar(p2))
  println(p1.isSimilar(p3))
  // Ponto.naoESemelhante foi definido na classe Similaridade
  println(p1.notSimilar(2))//accepts any type as p1.x is 2 this will be return TRUE
  println(p1.notSimilar(p4))



  //Tuples
  val pair = (99, "Luftballons")
  println(pair._1 + " " + pair._2)
  //another way to represent tuples is
  val (name, age) = ("John", 25)
  println(name + " is " + age + " years old")

  //we can use for to iterate over a list of tuples
  val numPars = List((2, 5), (3, -7), (20, 56))
  for ((a, b) <- numPars) { //for each tuple in the list is passing to a and b
    println(a * b)
  }

  //Pattern matching
  val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
      ("Mars", 227.9), ("Jupiter", 778.3), ("Saturn", 1427.0), ("Uranus", 2871.0),
      ("Neptune", 4497.1), ("Pluto", 5913.0))
  //using foreach to iterate over the list of tuples and pattern matching to match the tuple
  planets.foreach {
    case ("Earth", distance) =>
      println(s"Earth distance $distance million km of the Sun")
    case _ =>
  }

  //using case class instead tuples to represent planets
  val planet = new Planet("Tairone", 2.5)
  println(planet)

  //we can copy case classes and change some values using copy method and named parameters
  val copiedPlanet = planet.copy()
  println("copiedPlanet = "+copiedPlanet)

  val newPlanet = planet.copy(name = "Tairone Jr")
  println(newPlanet)

  //using inner functions
  println(FilterTest.filter(List(1, 9, 2, 8, 3, 7, 4), 5)) //filtering items less than 5


  //using twice extractor
  val extractor = Twice(21)
  extractor match {
    case Twice(n) => Console.println("extractor -> "+n)//prints 21
  }

  //using upper bound
  val cat = new Cat
  val dog = new Dog
  val lion = new Lion
  val cage = new Cage(cat)
  println(cage.pet.name)
  //val cage2 = new Cage(lion) //this will not compile as Lion is not a Pet


  //using TaironeString class
  //define a array of character
  val charArray = Array('T', 'a', 'i', 'r', 'o', 'n', 'e')
  val taironeString = new TaironeString(charArray)
  println("make string: "+taironeString.toArray.mkString)
  println("reverse string: "+taironeString.reverse.toArray.mkString)
  println("length string: "+taironeString.length)
  println("check is empty: "+taironeString.isEmpty)
  println("replace T for K string: "+taironeString.replace('T', 'K').mkString)
  println("substring three first chars: "+taironeString.substring(0, 3).mkString)
  println("charAt element at position 4: "+taironeString.charAt(3))
  println("string to JSON: "+taironeString.toJson)
  println("indexOF : "+taironeString.indexOf('r'))
  println("hashCode : "+taironeString.hashCode())
  taironeString.forEach()
  val taironeStringIterator = taironeString.iterator
  println("iterator hasNext: "+taironeStringIterator.hasNext)
  println("iterator next: "+taironeStringIterator.next())
  println("iterator hasNext: "+taironeStringIterator.hasNext)
  println("iterator next: "+taironeStringIterator.next())
  println("iterator hasNext: "+taironeStringIterator.hasNext)
  println("iterator next: "+taironeStringIterator.next())

  val testeTrim = new TaironeString("  Tairone  is testing my trim method  ".toCharArray());
  println("trim string: "+testeTrim.trim.mkString)

  taironeString.foreach(print(_))

  val old = new TaironeString("one".toCharArray())
  val neew = new TaironeString("two".toCharArray())
  print("new replace "+taironeString.replace(old, neew).toArray.mkString)

}//end main


/*
  class are statical templates that always have a constructor
  */
  class Point(var x: Int, var y: Int) extends Similarity {

    def move(dx: Int, dy: Int): Unit = { //Unit is like void in Java
      x = x + dx
      y = y + dy
    }

    override def toString: String = "(" + x + ", " + y + ")"

    def isSimilar(obj: Any): Boolean = obj.isInstanceOf[Point] &&  obj.asInstanceOf[Point].x == x
  }

  trait Similarity {
    def isSimilar(x: Any): Boolean //if point shares the same x then is similar
    def notSimilar(x: Any): Boolean = !isSimilar(x) //default implementation
  }

  //case class is a class that is immutable and compared by value
  case class Planet(name: String, distance: Double)

//object is a singleton class that is used to hold static methods and fields
object FilterTest extends App {
    def filter(xs: List[Int], threshold: Int): Seq[Int] = { //filter is an inner function that receives a list of integers and a threshold
      def process(ys: List[Int]): List[Int] = //process is an inner function that receives a list of integers
        if (ys.isEmpty) ys
        else if (ys.head < threshold) ys.head :: process(ys.tail) //uses threshold to filter the list
        else process(ys.tail)
      process(xs)
    }
}

//extractor object is used to extract values from a case class or object using unapply method original values are stored in apply method
object Twice {
  def apply(x: Int): Int = x * 2 //apply method is used to create a new instance of the object
  def unapply(z: Int): Option[Int] = if (z%2 == 0) Some(z/2) else None //unapply method is used to extract values from the object
}

//boundaries are used to limit the scope of a type
//upper bound is used to limit the type to a specific type
//lower bound is used to limit the type to a specific type or its super type
//view bound is used to limit the type to a specific type or its super type
//context bound is used to limit the type to a specific type or its super type
//type class is used to define a type that can be used as a parameter in a function
abstract class Animal {
  def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
  override def name: String = "Garfield"
}

class Dog extends Pet {
  override def name: String = "Snoopy"
}

class Lion extends Animal {
  override def name: String = "Simba"
}

class Cage[P <: Pet](p: P) {
  def pet: P = p
}
