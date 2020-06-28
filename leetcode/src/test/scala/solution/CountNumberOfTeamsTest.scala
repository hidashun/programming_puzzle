package solution

import org.scalatest.FunSuite

class CountNumberOfTeamsTest extends FunSuite {
  test("1") {
    val result = CountNumberOfTeams.Solution.numTeams(
      Array(2, 5, 3, 4, 1)
    )
    assert(result == 3)
  }

  test("2") {
    val result = CountNumberOfTeams.Solution.numTeams(
      Array(2, 1, 3)
    )
    assert(result == 0)
  }

  test("3") {
    val result = CountNumberOfTeams.Solution.numTeams(
      Array(1, 2, 3, 4)
    )
    assert(result == 4)
  }
}
