package solution

import org.scalatest.FunSuite

class MissingIntegerTest extends FunSuite {

  test("testSolution 1") {
    assert(MissingInteger.solution(Array(1, 2, 3)) == 4)
  }

  test("testSolution 2") {
    assert(MissingInteger.solution(Array(-1, -3)) == 1)
  }

}
