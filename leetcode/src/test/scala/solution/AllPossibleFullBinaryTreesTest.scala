package solution

import org.scalatest.FunSuite
import solution.AllPossibleFullBinaryTrees.TreeNode

class AllPossibleFullBinaryTreesTest extends FunSuite {
  test("1") {
    val result = AllPossibleFullBinaryTrees.Solution.allPossibleFBT(1)

    val expected: List[TreeNode] = List(
      // 1
      new TreeNode(
        0,
      ),
    )

    assert(expected.map(_.toString).toSet == result.map(_.toString).toSet)
  }

  test("2") {
    val result = AllPossibleFullBinaryTrees.Solution.allPossibleFBT(2)

    val expected: List[TreeNode] = List()

    assert(expected.map(_.toString).toSet == result.map(_.toString).toSet)
  }

  test("3") {
    val result = AllPossibleFullBinaryTrees.Solution.allPossibleFBT(3)

    val expected: List[TreeNode] = List(
      new TreeNode(
        0,
        new TreeNode(0),
        new TreeNode(0),
      )
    )

    assert(expected.map(_.toString).toSet == result.map(_.toString).toSet)
  }

  test("7") {
    val result = AllPossibleFullBinaryTrees.Solution.allPossibleFBT(7)

    val expected: List[TreeNode] = List(
      // 1
      new TreeNode(
        0,
        new TreeNode(0),
        new TreeNode(
          0,
          new TreeNode(0),
          new TreeNode(
            0,
            new TreeNode(0),
            new TreeNode(0),
          ),
        ),
      ),
      // 2
      new TreeNode(
        0,
        new TreeNode(0),
        new TreeNode(
          0,
          new TreeNode(
            0,
            new TreeNode(0),
            new TreeNode(0),
          ),
          new TreeNode(0),
        )
      ),
      // 3
      new TreeNode(
        0,
        new TreeNode(
          0,
          new TreeNode(0),
          new TreeNode(0),
        ),
        new TreeNode(
          0,
          new TreeNode(0),
          new TreeNode(0),
        )
      ),
      // 4
      new TreeNode(
        0,
        new TreeNode(
          0,
          new TreeNode(0),
          new TreeNode(
            0,
            new TreeNode(0),
            new TreeNode(0),
          ),
        ),
        new TreeNode(0),
      ),
      // 5
      new TreeNode(
        0,
        new TreeNode(
          0,
          new TreeNode(
            0,
            new TreeNode(0),
            new TreeNode(0),
          ),
          new TreeNode(0),
        ),
        new TreeNode(0),
      ),
    )

    assert(result.length == expected.length)
    assert(expected.forall { v =>  result.contains(v) })
  }
}
