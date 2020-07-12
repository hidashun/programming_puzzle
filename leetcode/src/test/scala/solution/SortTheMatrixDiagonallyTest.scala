package solution

import org.scalatest.FunSuite

class SortTheMatrixDiagonallyTest extends FunSuite {
  test("1") {
   val mat: Array[Array[Int]] = Array(
     Array(3, 3, 1, 1),
     Array(2, 2, 1, 2),
     Array(1, 1, 1, 2),
   )

    val expected: Array[Array[Int]] = Array(
      Array(1, 1, 1, 1),
      Array(1, 2, 2, 2),
      Array(1, 2, 3, 3),
    )

    val result = SortTheMatrixDiagonally.Solution.diagonalSort(mat)

    assert(result.map(_.mkString(",")).mkString(";") == expected.map(_.mkString(",")).mkString(";"))
  }
}
