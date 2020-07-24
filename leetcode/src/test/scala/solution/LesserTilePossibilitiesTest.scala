package solution

import org.scalatest.FunSuite

class LesserTilePossibilitiesTest extends FunSuite {
  test("1") {
    // A, B, AA, AB, BA, AAB, ABA, BAA
    // 1: 2
    // 2: 3
    // 3: 3
    assert(LetterTilePossibilities.Solution.numTilePossibilities("AAB") == 8)
  }

  test("2") {
    // 1: 3
    // 2: 3*2 (AB, AC, ...); 2 (AA, BB)
    // 3: 3*2 (ABC, ACB, ...); 6 (A2つ)； 6 (B2つ)
    // 4:
    assert(LetterTilePossibilities.Solution.numTilePossibilities("AAABBC") == 188)
  }

  test("My 1") {
    // A
    // 1: 1
    assert(LetterTilePossibilities.Solution.numTilePossibilities("A") == 1)
  }

  test("My 2") {
    // A, B, AB, BA
    // 1: 2
    // 2: 2
    assert(LetterTilePossibilities.Solution.numTilePossibilities("AB") == 4)
  }

  test("My 3") {
    // A, AA
    // 1: 1
    // 2: 1
    assert(LetterTilePossibilities.Solution.numTilePossibilities("AA") == 2)
  }
}
