package solution

object ScoreOfParentheses {
  def scoreOfParentheses(S: String): Int = {
    import scala.collection.mutable
    val stack: mutable.Stack[Int] = mutable.Stack(0)

    for {
      parentheses <- S
    } {
      parentheses match {
        case '(' =>
          stack.push(0)
        case ')' =>
          val top = stack.pop() match {
            case 0 => 1
            case n => n * 2
          }
          val nextTop = if (stack.nonEmpty) stack.pop() else 0
          stack.push(nextTop + top)
      }
    }
    stack.pop()
  }
}
