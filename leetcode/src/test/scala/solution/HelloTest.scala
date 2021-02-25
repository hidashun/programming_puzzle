package solution

import org.scalatest.FunSuite

class HelloTest extends FunSuite {
  test("1") {
    val result = Hello.hello(Array.empty)

    assert(result.output.toSeq == Seq("Hello", "Hello", "Hello"))
  }
}
