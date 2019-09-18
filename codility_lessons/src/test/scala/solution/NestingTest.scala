package solution

import org.scalatest.FunSuite

class NestingTest extends FunSuite {
  test("testSolution1") {
    assert(Nesting.solution("(()(())())") == 1)
  }

  test("testSolution2") {
    assert(Nesting.solution("())") == 0)
  }

  test("testSolution3") {
    assert(Nesting.solution("))((") == 0)
  }

  test("testSolution4") {
    assert(Nesting.solution("())(()") == 0)
  }

  test("testSolution5") {
    assert(Nesting.solution("") == 1)
  }

  test("testSolution6") {
    assert(Nesting.solution("()(()())((()())(()()))") == 1)
  }

  test("testSolution7") {
    assert(Nesting.solution("()(()()(((()())(()()))") == 0)
  }

  test("testSolution8") {
    assert(Nesting.solution(")(") == 0)
  }

  test("testSolution9") {
    assert(Nesting.solution("())((((()())())()))(") == 0)
  }

  test("testSolution10") {
    assert(Nesting.solution("()()()(()(())()())()") == 1)
  }

  test("testSolution11") {
    assert(Nesting.solution(")())))())(((((()()()") == 0)
  }
}
