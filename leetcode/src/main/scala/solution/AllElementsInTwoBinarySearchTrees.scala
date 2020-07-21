package solution

object AllElementsInTwoBinarySearchTrees {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"T($value, $left, $right)"
    }
  }

  object Solution {
    def nodeToList(node: TreeNode): List[Int] = {
      if (node != null) {
        nodeToList(node.left) ++ List(node.value) ++ nodeToList(node.right)
      } else {
        List.empty
      }
    }

    def getAllElements(root1: TreeNode, root2: TreeNode): List[Int] = {
      (nodeToList(root1) ++ nodeToList(root2)).sorted
    }
  }
}
