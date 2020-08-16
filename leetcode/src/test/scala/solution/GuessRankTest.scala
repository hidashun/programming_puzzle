package solution

import org.scalatest.FunSuite
import solution.GuessRank.Answer

class GuessRankTest extends FunSuite {
  /*
     13 14
     23 24 25
  31 32 34 35
  41 42 43
     52 53
   */
  test("345") { // 3 pattern
    val result = GuessRank.Solution.getAnswers(Seq(3, 4, 5), 5)
    assert(result == Seq(Answer.Min))
  }

  test("312") { // 3 pattern
    val result = GuessRank.Solution.getAnswers(Seq(3, 1, 2), 5)
    assert(result == Seq(Answer.Max))
  }

  test("315") { // 3 pattern
    val result = GuessRank.Solution.getAnswers(Seq(3, 1, 5), 5)
    assert(result == Seq(Answer.Mid))
  }

  test("213") {
    // a Mid or Max
    val result = GuessRank.Solution.getAnswers(Seq(2, 1, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Max))
  }
  // ---
  test("413") {
    val result = GuessRank.Solution.getAnswers(Seq(4, 1, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Mid))
  }

  test("513") {
    val result = GuessRank.Solution.getAnswers(Seq(5, 1, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Mid))
  }
  // ---
  test("214") {
    val result = GuessRank.Solution.getAnswers(Seq(2, 1, 4), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Max))
  }

  test("314") {
    val result = GuessRank.Solution.getAnswers(Seq(3, 1, 4), 5)
    assert(result == Seq(Answer.Unknown, Answer.Min))
  }

  test("514") {
    val result = GuessRank.Solution.getAnswers(Seq(5, 1, 4), 5)
    assert(result == Seq(Answer.Unknown, Answer.Min))
  }
  // ---
  test("123") {
    val result = GuessRank.Solution.getAnswers(Seq(1, 2, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Max))
  }

  test("423") {
    val result = GuessRank.Solution.getAnswers(Seq(4, 2, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Mid))
  }

  test("523") {
    val result = GuessRank.Solution.getAnswers(Seq(5, 2, 3), 5)
    assert(result == Seq(Answer.Unknown, Answer.Unknown, Answer.Mid))
  }

  test("print all") {
    val possibilities = (1 to 5).combinations(3).flatMap(_.permutations)
    possibilities foreach {
      cards =>
        println(cards.mkString(","))
        val result = GuessRank.Solution.getAnswers(cards, 5)
        println(result)
    }
    assert(1 == 1)
  }
}
