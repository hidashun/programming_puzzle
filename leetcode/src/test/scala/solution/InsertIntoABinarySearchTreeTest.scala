package solution

import org.scalatest.FunSuite
import solution.InsertIntoABinarySearchTree.TreeNode

class InsertIntoABinarySearchTreeTest extends FunSuite {
  test("1") {
    val node = new TreeNode(
      4,
      new TreeNode(
        2,
        new TreeNode(1),
        new TreeNode(3),
      ),
      new TreeNode(7),
    )
    val result = InsertIntoABinarySearchTree.Solution.insertIntoBST(node, 5)
    val expected = new TreeNode(
      4,
      new TreeNode(
        2,
        new TreeNode(1),
        new TreeNode(3),
      ),
      new TreeNode(
        5,
        null,
        new TreeNode(7),
      ),
    )
    assert(result.toString == expected.toString)
  }

  test("2") {
    val node = new TreeNode(
      40,
      new TreeNode(
        20,
        new TreeNode(10),
        new TreeNode(30),
      ),
      new TreeNode(
        60,
        new TreeNode(50),
        new TreeNode(70),
      ),
    )
    val result = InsertIntoABinarySearchTree.Solution.insertIntoBST(node, 25)
    val expected = new TreeNode(
      40,
      new TreeNode(
        25,
        new TreeNode(
          20,
          new TreeNode(10),
        ),
        new TreeNode(30),
      ),
      new TreeNode(
        60,
        new TreeNode(50),
        new TreeNode(70),
      ),
    )
    println(result)
    println(expected)
    assert(result.toString == expected.toString)
  }

  test("3") {
    val node = new TreeNode(
      8,
      null,
      new TreeNode(
        55,
        new TreeNode(
          39,
          new TreeNode(
            11,
            null,
            new TreeNode(
              23,
            )
          ),
        ),
      ),
    )
    val result = InsertIntoABinarySearchTree.Solution.insertIntoBST(node, 17)
    val expected = new TreeNode(
      8,
      null,
      new TreeNode(
        55,
        new TreeNode(
          39,
          new TreeNode(
            17,
            new TreeNode( 11),
            new TreeNode( 23),
          ),
        ),
      ),
    )
    println(result)
    println(expected)
    assert(result.toString == expected.toString)
  }

  test("4") {
    val node = null
    val result = InsertIntoABinarySearchTree.Solution.insertIntoBST(node, 5)
    val expected = new TreeNode(5)
    println(result)
    println(expected)
    assert(result.toString == expected.toString)
  }
}
