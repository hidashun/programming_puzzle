package solution

object MaximumBinaryTree {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"T(${_value}, ${_left}, ${_right})"
    }
  }

 object Solution {
    def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
      val maxIndexOpt = nums.indices.maxByOption(nums)
      maxIndexOpt match {
        case Some(maxIndex) => new TreeNode(
          _value = nums(maxIndex),
          _left  = constructMaximumBinaryTree(nums.slice(0, maxIndex)),
          _right = constructMaximumBinaryTree(nums.slice(maxIndex + 1, nums.length)),

        )
        case None => null
      }
    }
 }
}
