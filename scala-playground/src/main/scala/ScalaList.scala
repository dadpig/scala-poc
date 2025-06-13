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
                        
  

