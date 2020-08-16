package solution

object AllPossibleFullBinaryTrees {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"T($value, $left, $right)"
    }

    override def equals(other: Any): Boolean = {
      other match {
        case _: TreeNode =>
          this.toString == other.toString
        case _ => false
      }
    }
  }

  object Solution {
    def allPossibleFBT(N: Int): List[TreeNode] = {
      N match {
        case 1 =>
          List(new TreeNode(0))
        case n if n % 2 == 0 =>
          Nil
        case n if n % 2 == 1 => List.range(1, n - 1) flatMap {
          (m: Int) => {
            for {
              l <- allPossibleFBT(m)
              r <- allPossibleFBT(n - m - 1)
            } yield {
              new TreeNode(
                0,
                l,
                r,
              )
            }
          }
        }
      }
    }
  }
}
