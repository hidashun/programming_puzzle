package solution

import org.scalatest.FunSuite

class QueriesOnAPermutationWithKeyTest extends FunSuite {
  test("1") {
    val result = QueriesOnAPermutationWithKey.Solution.processQueries(
      Array(3, 1, 2, 1), 5
    )
    println(result.map(_.toString).mkString(","))
    assert(result sameElements Array(2, 1, 2, 1))
  }

  test("2") {
    val result = QueriesOnAPermutationWithKey.Solution.processQueries(
      Array(4, 1, 2, 2), 4
      )
    println(result.map(_.toString).mkString(","))
    assert(result sameElements Array(3, 1, 2, 0))
  }

  test("3") {
    val result = QueriesOnAPermutationWithKey.Solution.processQueries(
      Array(7, 5, 5, 8, 3), 8
      )
    println(result.map(_.toString).mkString(","))
    assert(result sameElements Array(6, 5, 0, 7, 5))
  }
}
