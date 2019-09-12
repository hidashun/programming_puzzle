package solution

import org.scalatest.FunSuite

class FishTest extends FunSuite {

  test("testSolution1") {
    assert(Fish.solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)) == 2)
  }

  test("testSolution2") {
    assert(Fish.solution(Array(1), Array(0)) == 1)
  }

  test("testSolution3") {
    assert(Fish.solution(Array(1000000000), Array(1)) == 1)
  }

  test("testSolution4") {
    assert(Fish.solution(Array(0, 1), Array(1, 1)) == 2)
  }

  test("testSolution5") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(0, 0)) == 2)
  }

  test("testSolution6") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(1, 0)) == 1)
  }

  test("testSolution7") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(0, 1)) == 2)
  }

  test("testSolution8") {
    assert(Fish.solution(Array(999999999, 1000000000), Array(1, 0)) == 1)
  }

  test("testSolution9") {
    assert(Fish.solution(Array(8, 6, 5, 3, 2, 4, 7), Array(1, 1, 1, 0, 0, 1, 1)) == 5)
  }

  test("testSolution10") {
    assert(Fish.solution(Array(8, 6, 5, 3, 2, 4, 7), Array(1, 1, 1, 1, 1, 0, 0)) == 1)
  }

  test("testSolution11") {
    assert(Fish.solution(Array(8, 6, 4, 2, 1, 3, 5), Array(1, 1, 1, 1, 1, 0, 0)) == 2)
  }
}
