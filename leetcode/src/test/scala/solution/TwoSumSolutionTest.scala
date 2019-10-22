package solution

import org.scalatest.FunSuite

class TwoSumSolutionTest extends FunSuite {

  test("testTwoSum") {
    assert(TwoSumSolution.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
  }

}
