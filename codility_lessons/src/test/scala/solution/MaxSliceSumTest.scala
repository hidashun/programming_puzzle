package solution

import org.scalatest.FunSuite

class MaxSliceSumTest extends FunSuite {
  test("testSolution0") {
    assert(MaxSliceSum.solution(Array(3, 2, -6, 4, 0)) == 5)
  }

  test("testSolution1") {
    assert(MaxSliceSum.solution(Array(-10)) == -10)
  }

  test("testSolution2") {
    assert(MaxSliceSum.solution(Array(0)) == 0)
  }

  test("testSolution3") {
    assert(MaxSliceSum.solution(Array(10)) == 10)
  }

  test("testSolution4") {
    assert(MaxSliceSum.solution(Array(-2, -2)) == -2)
  }

  test("testSolution5") {
    assert(MaxSliceSum.solution(Array(-2, 1)) == 1)
  }

  test("testSolution6") {
    assert(MaxSliceSum.solution(Array(-2, 3)) == 3)
  }

  test("testSolution7") {
    assert(MaxSliceSum.solution(Array(1, -2)) == 1)
  }

  test("testSolution8") {
    assert(MaxSliceSum.solution(Array(1, 1)) == 2)
  }

  test("testSolution9") {
    assert(MaxSliceSum.solution(Array(1, 3)) == 4)
  }

  test("testSolution10") {
    assert(MaxSliceSum.solution(Array(3, -2)) == 3)
  }

  test("testSolution11") {
    assert(MaxSliceSum.solution(Array(3, 1)) == 4)
  }

  test("testSolution12") {
    assert(MaxSliceSum.solution(Array(3, 3)) == 6)
  }

  test("testSolution13") {
    assert(MaxSliceSum.solution(Array(-2, -2, -2)) == -2)
  }

  test("testSolution14") {
    assert(MaxSliceSum.solution(Array(-2, -2, 1)) == 1)
  }

  test("testSolution15") {
    assert(MaxSliceSum.solution(Array(-2, -2, 3)) == 3)
  }

  test("testSolution16") {
    assert(MaxSliceSum.solution(Array(-2, 1, -2)) == 1)
  }

  test("testSolution17") {
    assert(MaxSliceSum.solution(Array(-2, 1, 1)) == 2)
  }

  test("testSolution18") {
    assert(MaxSliceSum.solution(Array(-2, 1, 3)) == 4)
  }

  test("testSolution19") {
    assert(MaxSliceSum.solution(Array(-2, 3, -2)) == 3)
  }

  test("testSolution20") {
    assert(MaxSliceSum.solution(Array(-2, 3, 1)) == 4)
  }

  test("testSolution21") {
    assert(MaxSliceSum.solution(Array(-2, 3, 3)) == 6)
  }

  test("testSolution22") {
    assert(MaxSliceSum.solution(Array(1, -2, -2)) == 1)
  }

  test("testSolution23") {
    assert(MaxSliceSum.solution(Array(1, -2, 1)) == 1)
  }

  test("testSolution24") {
    assert(MaxSliceSum.solution(Array(1, -2, 3)) == 3)
  }

  test("testSolution25") {
    assert(MaxSliceSum.solution(Array(1, 1, -2)) == 2)
  }

  test("testSolution26") {
    assert(MaxSliceSum.solution(Array(1, 1, 1)) == 3)
  }

  test("testSolution27") {
    assert(MaxSliceSum.solution(Array(1, 1, 3)) == 5)
  }

  test("testSolution28") {
    assert(MaxSliceSum.solution(Array(1, 3, -2)) == 4)
  }

  test("testSolution29") {
    assert(MaxSliceSum.solution(Array(1, 3, 1)) == 5)
  }

  test("testSolution30") {
    assert(MaxSliceSum.solution(Array(1, 3, 3)) == 7)
  }

  test("testSolution31") {
    assert(MaxSliceSum.solution(Array(3, -2, -2)) == 3)
  }

  test("testSolution32") {
    assert(MaxSliceSum.solution(Array(3, -2, 1)) == 3)
  }

  test("testSolution33") {
    assert(MaxSliceSum.solution(Array(3, -2, 3)) == 4)
  }

  test("testSolution34") {
    assert(MaxSliceSum.solution(Array(3, 1, -2)) == 4)
  }

  test("testSolution35") {
    assert(MaxSliceSum.solution(Array(3, 1, 1)) == 5)
  }

  test("testSolution36") {
    assert(MaxSliceSum.solution(Array(3, 3, -2)) == 6)
  }

  test("testSolution37") {
    assert(MaxSliceSum.solution(Array(3, 3, 1)) == 7)
  }

  test("testSolution38") {
    assert(MaxSliceSum.solution(Array(3, 3, 3)) == 9)
  }

  test("testSolution39") {
    assert(MaxSliceSum.solution(Array(1,3,-5,3,7,14,29)) == 53)
  }

  test("testSolution40") {
    assert(MaxSliceSum.solution(Array(-1000000)) == -1000000)
  }

  test("testSolution41") {
    assert(MaxSliceSum.solution(Array(-191,358,-145,41,-893,545,-770,-560,495,-488,565,568,-353,-782,719,727,-269,16,432,98,934,-795,744,-966,-654,-973,-529,-588,129,565,42,-11,338,525,190,-855,189,-434,272,49,561,-872,898,-859,-595,-852,-591,-103,-641,-480)) == 2662)
  }

  test("testSolution42") {
    assert(MaxSliceSum.solution(Array(-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11,-11)) == -11)
  }

  test("testSolution43") {
    assert(MaxSliceSum.solution(Array(11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11)) == 550)
  }
}
