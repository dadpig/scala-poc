
import org.scalatest.{FunSuite, Matchers}

class NQueensSolverTest extends FunSuite with Matchers {

  test("NQueensSolver.solveNQueens should return all solutions for n = 4") {
    val n = 4
    val expectedSolutions = List(
      List("0 1 0 0 ", "0 0 0 1 ", "1 0 0 0 ", "0 0 1 0 "),
      List("0 0 1 0 .", "1 0 0 0 ", "0 0 0 1 ", "0 1 0 0 ")
    )

    val solutions = QueenBord.solveNQueens(n)
    solutions should contain theSameElementsAs expectedSolutions
  }

  test("NQueensSolver.solveNQueens should return an empty list for n = 2") {
    val n = 2
    val expectedSolutions = List.empty

    val solutions = QueenBord.solveNQueens(n)
    solutions shouldBe expectedSolutions
  }

  test("NQueensSolver.solveNQueens should return all solutions for n = 8") {
    val n = 8
    val solutions = QueenBord.solveNQueens(n)

    solutions.size shouldBe 92 // There are 92 solutions for the 8-Queens problem
    solutions.forall(_.length == n) shouldBe true // Each solution should have length equal to n
  }

  test("NQueensSolver.solveNQueens should return all solutions for n = 1") {
    val n = 1
    val expectedSolutions = List(List("Q"))

    val solutions = QueenBord.solveNQueens(n)
    solutions should contain theSameElementsAs expectedSolutions
  }
}