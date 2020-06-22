package solution

import org.scalatest.FunSuite

class SubrectangleQueriesProblemTest extends FunSuite {
  test("1") {
   val result = SubrectangleQueriesProblem.run(
     Array(
       Array(1, 2, 1),
       Array(4, 3, 4),
       Array(3, 2, 1),
       Array(1, 1, 1),
     ),
     Seq("getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"),
     Array(Array(0,2),Array(0,0,3,2,5),Array(0,2),Array(3,1),Array(3,0,3,2,10),Array(3,1),Array(0,2))
   )
    assert(result sameElements Array[Option[Int]](None, Some(1), None, Some(5), Some(5), None, Some(10), Some(5)))
  }

  test("2") {
    val result = SubrectangleQueriesProblem.run(
      Array(
        Array(1, 1, 1),
        Array(2, 2, 2),
        Array(3, 3, 3),
        ),
      Seq("getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"),
      Array(Array(0,0),Array(0,0,2,2,100),Array(0,0),Array(2,2),Array(1,1,2,2,20),Array(2,2))
      )
    assert(result sameElements Array[Option[Int]](None, Some(1), None, Some(100), Some(100), None, Some(20)))
  }
}
