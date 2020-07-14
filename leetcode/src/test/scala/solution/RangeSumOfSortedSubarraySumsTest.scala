package solution

import org.scalatest.FunSuite

class RangeSumOfSortedSubarraySumsTest extends FunSuite {
  test("1") {
    val result = RangeSumOfSortedSubarraySums.Solution.rangeSum(Array(1, 2, 3, 4), 4, 1, 5)
    assert(result == 13)
  }

  test("2") {
    val result = RangeSumOfSortedSubarraySums.Solution.rangeSum(Array(1, 2, 3, 4), 4, 3, 4)
    assert(result == 6)
  }

  test("3") {
    val result = RangeSumOfSortedSubarraySums.Solution.rangeSum(Array(1, 2, 3, 4), 4, 1, 10)
    assert(result == 50)
  }
}
