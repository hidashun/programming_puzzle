package solution

import org.scalatest.FunSuite
import solution.BinarySearchTreeToGreaterSumTree.Solution.TreeNodeAndAcc
import solution.BinarySearchTreeToGreaterSumTree.TreeNode

class BinarySearchTreeToGreaterSumTreeTest extends FunSuite {
  test("1") {
    val node = new TreeNode(
      _value = 4,
      _left  = new TreeNode(
        _value = 1,
        _left  = new TreeNode(
          _value = 0,
        ),
        _right = new TreeNode(
          _value = 2,
          _right = new TreeNode(
            _value = 3,
          ),
        ),
      ),
      _right = new TreeNode(
        _value = 6,
        _left = new TreeNode(
          _value = 5,
        ),
        _right = new TreeNode(
          _value = 7,
          _right = new TreeNode(
            _value = 8
          ),
        ),
      ),
    )
    val tmp2 = BinarySearchTreeToGreaterSumTree.Solution.bstToGst(node)
    val tmp = BinarySearchTreeToGreaterSumTree.Solution.TreeNodeSerializer.serialize(tmp2)
    println(tmp.map(_.toString).mkString(","))
    assert(tmp == Seq[Option[Int]](
      Some(30),
      Some(36),
      Some(21),
      Some(36),
      Some(35),
      Some(26),
      Some(15),
      None,
      None,
      None,
      Some(33),
      None,
      None,
      None,
      Some(8),
      None,
      None,
      None,
      None,
    ))
  }
}
