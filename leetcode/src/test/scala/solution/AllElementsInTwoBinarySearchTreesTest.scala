package solution

import org.scalatest.FunSuite
import solution.AllElementsInTwoBinarySearchTrees.TreeNode

class AllElementsInTwoBinarySearchTreesTest extends FunSuite {
  test("1") {
    val root1 = new TreeNode(
      2,
      new TreeNode(1),
      new TreeNode(4),
    )
    val root2 = new TreeNode(
      1,
      new TreeNode(0),
      new TreeNode(3),
    )
    val result = AllElementsInTwoBinarySearchTrees.Solution.getAllElements(root1, root2)
    assert(result == List(0, 1, 1, 2, 3, 4))
  }
}
