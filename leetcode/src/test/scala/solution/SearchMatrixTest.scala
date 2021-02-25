package solution

import org.scalatest.FunSuite

class SearchMatrixTest extends FunSuite {
  val matrix: Array[Array[Int]] = Array(
    Array( 1,  4,  7, 11, 15),
    Array( 2,  5,  8, 12, 19),
    Array( 3,  6,  9, 16, 22),
    Array(10, 13, 14, 17, 24),
    Array(18, 21, 23, 26, 30),
    )

  val matrix2: Array[Array[Int]] = Array(
    Array( 1,  3,  5,  7,  9),
    Array( 2,  4,  6,  8, 10),
    Array(11, 13, 15, 17, 19),
    Array(12, 14, 16, 18, 20),
    Array(21, 22, 23, 24, 25),
    )

  val matrix3: Array[Array[Int]] = Array(
    Array(4,7,11,12,16,21,23,26),
    Array(5,12,17,17,18,23,26,31),
    Array(8,15,21,25,26,29,33,34),
    Array(13,20,26,26,29,34,39,40),
    Array(18,21,31,36,41,42,42,44),
    Array(19,23,31,39,46,49,50,53),
    Array(23,25,33,40,50,51,55,60),
    Array(27,28,33,44,51,56,61,65),
    Array(32,35,39,45,54,56,65,68),
    Array(33,38,40,49,56,57,66,71)
    )

  val matrix4: Array[Array[Int]] = Array(Array(1, 3, 5))

  test("4:3") {
    val result = SearchMatrix.searchMatrix(
      matrix4,
      3
      )
    assert(result)
  }

  test("3:51") {
    val result = SearchMatrix.searchMatrix(
      matrix3,
      51
      )
    assert(result)
  }

  test("2:8") {
    val result = SearchMatrix.searchMatrix(
      matrix2,
      8
      )
    assert(result)
  }

  test("2:13") {
    val result = SearchMatrix.searchMatrix(
      matrix2,
      13
      )
    assert(result)
  }

  test("5") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      5
      )
    assert(result)
  }

  test("15") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      15
      )
    assert(result)
  }

  test("18") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      18
      )
    assert(result)
  }

  test("30") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      30
      )
    assert(result)
  }

  test("24") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      24
      )
    assert(result)
  }

  test("20") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      20
      )
    assert(!result)
  }

  test("25") {
    val result = SearchMatrix.searchMatrix(
      matrix,
      25
      )
    assert(!result)
  }
}
