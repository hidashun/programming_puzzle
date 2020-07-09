package solution

object InsertIntoABinarySearchTree {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"BST($value, $left, $right)"
    }
  }

  object Solution {
    @scala.annotation.tailrec
    def _insertIntoBST(root: TreeNode, `val`: Int): Unit = {
      if (`val` < root.value) {
        if (root.left == null) {
          root.left = new TreeNode(`val`)
        } else {
          if (root.left.value < `val`) {
            if (root.left.right == null || `val` < root.left.right.value) {
              root.left = new TreeNode(`val`, new TreeNode(root.left.value, root.left.left), root.left.right)
            } else {
              _insertIntoBST(root.left.right, `val`)
            }
          } else {
            _insertIntoBST(root.left, `val`)
          }
        }
      } else {
        if (root.right == null) {
          root.right = new TreeNode(`val`)
        } else {
          if (`val` < root.right.value ) {
            if (root.right.left == null || root.right.left.value < `val`) {
              root.right = new TreeNode(`val`, root.right.left, new TreeNode(root.right.value, root.right.right))
            } else {
              _insertIntoBST(root.right.left, `val`)
            }
          } else {
            _insertIntoBST(root.right, `val`)
          }
        }
      }
    }

    def insertIntoBST(root: TreeNode, `val`: Int): TreeNode = {
      if (root == null) { return new TreeNode(`val`) }
      if (`val` < root.value) {
        root.left = insertIntoBST(root.left, `val`)
      } else {
        root.right = insertIntoBST(root.right, `val`)
      }
      root
    }
  }
}
