package solution

import org.scalatest.FunSuite
import solution.MaximumBinaryTree.TreeNode

class MaximumBinaryTreeTest extends FunSuite {
  test("1") {
    val result = MaximumBinaryTree.Solution.constructMaximumBinaryTree(Array(3, 2, 1, 6, 0, 5))
    val expected = new TreeNode(
      6,
      new TreeNode(
        3,
        null,
        new TreeNode(
          2,
          null,
          new TreeNode(1)
        )
      ),
      new TreeNode(
        5,
        new TreeNode(0)
      )
    )
    assert(result.toString == expected.toString)
  }
}
