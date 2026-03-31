package leadrandori

object Matroid {

  //Matroid is a subset of combinatorial optimization that generalizes the notion of linear independence in vector spaces.
  //define a matroid as a pair (E, I) where E is a finite set and I is a collection of subsets of E
  //1. The empty set is in I.
  //2. If A is in I and B is a subset of A, then B is in I (hereditary property).
  //3. If A and B are in I and |A| < |B|, then there exists an element in B that is not in A such that A ∪ {x} is in I (exchange property).
  def isMatroid[E](E: Set[E], I: Set[Set[E]]): Boolean = {
    // Check if the empty set is in I
    if (!I.contains(Set.empty)) return false

    // Check hereditary property
    for (A <- I; B <- A.subsets) {
      if (!I.contains(B)) return false
    }

    // Check exchange property
    for (A <- I; B <- I if A.size < B.size) {
      val diff = B.diff(A)
      if (diff.isEmpty || !I.contains(A.union(Set(diff.head)))) return false
    }

    true
  }

  def main(args: Array[String]): Unit = {
    val number = Set(1, 2, 3)
    val numberSet = Set(Set.empty, Set(1), Set(2), Set(3), Set(1, 2), Set(1, 3), Set(2, 3))

    println(s"Is (number, numberSet) a matroid? ${isMatroid(number, numberSet)}")


    val letter = Set('a', 'b', 'c')
    val letterSet = Set(Set.empty, Set('a'), Set('b'), Set('c'), Set('a', 'b'), Set('a', 'c'), Set('b', 'c'))
    println(s"Is (letter, letterSet) a matroid? ${isMatroid(letter, letterSet)}")
  }



}
