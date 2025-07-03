import scala.collection.mutable

@main
def testListIntantiationPlusConcat() :Unit = {
  val oneTwo = List(1, 2)
  val threeFour = 3 :: 4 :: Nil
  val oneTwoThreeFour = oneTwo ::: threeFour

  print(oneTwoThreeFour)
}

def testTuples() :Unit =  {
  val pair = (99, "ninenith")
  val key = pair(0)
  val value = pair(1)

  print (pair)
}

def testSet() :Unit = {
  var jetSet = Set("Boing", "Airbus")
  jetSet += "Lear"
  println(jetSet)
  println(jetSet.contains("Cessna"))
}

def testTreasureMap():Unit = {
  val treasure = mutable.Map.empty[Int, String]
  treasure += (1 -> "Go to Island")
  treasure += (2 -> "Find the big X")
  treasure += (3 -> "Dig deeper")
  print(treasure)
}

def testRomanNumberMap():Unit = {
  val romanNum = Map(1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V")
  print(romanNum)
}

def testForYield():Unit = {
  val ques = Vector("Who", "What", "When", "Where", "Why")
  println(ques)
  val usingYield = for q <- ques yield q.toLowerCase + "?"
  println(usingYield)
}

def testFindWithOptional:Unit = {
  val ques = Vector("Who", "What", "When", "Where", "Why")

  val startsW = ques.find(q => q.startsWith("W") //Some("Who")
  val hasLen4 = ques.find(q => q.length(4) //Some("What")
  val startsH = ques.find(q => q.startsWith("H") //None
  println(startsW)
  println(hasLen4)
  println(startsH)
}
                        
  
// List concatenation (:::)
List(1, 2) ::: List(3, 4, 5) // Result: List(1, 2, 3, 4, 5)

// Divide and Conquer principle - Concatenation
def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

// Length
List(1, 2, 3).length // Result: 3

// Accessing end of a list - Init and Last
val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.last // Result: 'e'
abcde.init // Result: List('a', 'b', 'c', 'd')

// Reversing lists
abcde.reverse // Result: List('e', 'd', 'c', 'b', 'a')

// Prefixes and Suffixes - Drop, Take, SplitAt
abcde.take(2) // Result: List('a', 'b')
abcde.drop(2) // Result: List('c', 'd', 'e')
abcde.splitAt(2) // Result: (List('a', 'b'), List('c', 'd', 'e'))

// Element selection - Apply and Indices
abcde(2) // Result: 'c'
abcde.indices // Result: List(0, 1, 2, 3, 4)

// Zipping lists
abcde.indices zip abcde // Result: List((0,'a'), (1,'b'), (2,'c'), (3,'d'), (4,'e'))

// Displaying lists - ToString and MkString
abcde.toString // Result: "List(a, b, c, d, e)"
abcde.mkString("[", ",", "]") // Result: "[a,b,c,d,e]"

// Merge sort example
def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length / 2
  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

// Sorting with merge sort
msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)) // Result: List(1, 3, 5, 7)
