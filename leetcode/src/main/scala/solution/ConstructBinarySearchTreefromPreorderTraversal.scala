package solution

import scala.annotation.tailrec

object ConstructBinarySearchTreefromPreorderTraversal {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"T($value, $left, $right)"
    }
  }

  object Solution {
    def bstFromPreorder(preorder: Array[Int]): TreeNode = {
      val node = new TreeNode(preorder.head)
      preorder.slice(1, preorder.length).foreach(n =>
        append(node, n)
      )
      node
    }

    @tailrec
    def append(root: TreeNode, n: Int): Unit = {
      if (root.value > n) {
        if (root.left == null) { root.left = new TreeNode(n) }
        else { append(root.left, n) }
      } else {
        if (root.right == null) { root.right = new TreeNode(n) }
        else { append(root.right, n) }
      }
    }
  }
}
