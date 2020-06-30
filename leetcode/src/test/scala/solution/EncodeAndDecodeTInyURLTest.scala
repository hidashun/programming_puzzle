package solution

import org.scalatest.FunSuite

class EncodeAndDecodeTInyURLTest extends FunSuite {
  test("1") {
    val longURL = "https://leetcode.com/problems/design-tinyurl"
    val result = EncodeAndDecodeTinyURL.solve(longURL)
    assert(longURL == result)
  }
}
