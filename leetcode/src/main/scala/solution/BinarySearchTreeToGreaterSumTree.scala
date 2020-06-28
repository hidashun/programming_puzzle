package solution

object BinarySearchTreeToGreaterSumTree {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString: String = {
      s"BST($value, $left, $right)"
    }
  }

  object Solution {

    object TreeNodeSerializer {
      def serialize(root: TreeNode): Seq[Option[Int]] = {
        val q = scala.collection.mutable.Queue[Option[TreeNode]]()
        val r = scala.collection.mutable.ArrayBuffer[Option[Int]]()
        q.enqueue(Some(root))
        while (q.nonEmpty) {
          val n = q.dequeue()
          n match {
            case Some(treeNode) =>
              r.append(Some(treeNode.value))
              q.enqueue(Option(treeNode.left))
              q.enqueue(Option(treeNode.right))
            case None =>
              r.append(None)
          }
        }
        r
      }

      def serialize2(root: TreeNode): Seq[Option[Int]] = {
        val r = if (root.right != null) {
          serialize2(root.right)
        } else {
          Seq(None)
        }
        val l = if (root.left != null) {
          serialize2(root.left)
        } else {
          Seq(None)
        }
        r ++ Seq(Some(root.value)) ++ l
      }

    }

    case class TreeNodeAndAcc(node: TreeNode, acc: Int)

    def serialize3(root: TreeNodeAndAcc): TreeNodeAndAcc = {
      val r = if (root.node.right != null) {
        serialize3(TreeNodeAndAcc(root.node.right, root.acc))
      } else {
        null
      }
      val racc = if (r != null) r.acc else root.acc
      val newValue = root.node.value + racc
      val l = if (root.node.left != null) {
        serialize3(TreeNodeAndAcc(root.node.left, newValue))
      } else {
        null
      }
      val finalacc = if (l != null) l.acc else newValue
      TreeNodeAndAcc(
        new TreeNode(
          newValue,
          if (l != null) l.node else null,
          if (r != null) r.node else null,
        ),
        finalacc
      )
    }

    def bstToGst(root: TreeNode): TreeNode = {
      serialize3(TreeNodeAndAcc(root, 0)).node
    }
  }

}
