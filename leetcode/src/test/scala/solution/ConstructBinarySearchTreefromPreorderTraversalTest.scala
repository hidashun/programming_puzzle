package solution

import org.scalatest.FunSuite
import solution.ConstructBinarySearchTreefromPreorderTraversal.TreeNode

class ConstructBinarySearchTreefromPreorderTraversalTest extends FunSuite {
  test("") {
    val preorder = Array(8, 5, 1, 7, 10, 12)
    val result = ConstructBinarySearchTreefromPreorderTraversal.Solution.bstFromPreorder(preorder)

    val expected = new TreeNode(
      8,
      new TreeNode(
        5,
        new TreeNode(1),
        new TreeNode(7),
      ),
      new TreeNode(
        10,
        null,
        new TreeNode(12),
      ),
    )
    assert(result.toString == expected.toString)
  }
}
