package solution

import org.scalatest.FunSuite

class MinPerimeterRectangleTest extends FunSuite {
  test("testSolution1") {
    assert(MinPerimeterRectangle.solution(30) == 22)
  }

  test("testSolution2") {
    assert(MinPerimeterRectangle.solution(1) == 4)
  }

  test("testSolution3") {
    assert(MinPerimeterRectangle.solution(36) == 24)
  }

  test("testSolution4") {
    assert(MinPerimeterRectangle.solution(48) == 28)
  }

  test("testSolution5") {
    assert(MinPerimeterRectangle.solution(101) == 204)
  }

  test("testSolution6") {
    assert(MinPerimeterRectangle.solution(1234) == 1238)
  }

  test("testSolution7") {
    assert(MinPerimeterRectangle.solution(4564320) == 8552)
  }

  test("testSolution8") {
    assert(MinPerimeterRectangle.solution(15486451) == 30972904)
  }

  test("testSolution9") {
    assert(MinPerimeterRectangle.solution(100000000) == 40000)
  }

  test("testSolution10") {
    assert(MinPerimeterRectangle.solution(982451653) == 1964903308)
  }

  test("testSolution11") {
    assert(MinPerimeterRectangle.solution(1000000000) == 126500)
  }
}
