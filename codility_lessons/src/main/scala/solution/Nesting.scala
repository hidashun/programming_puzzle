package solution

object Nesting {
 def solution(s: String): Int = {
   import scala.collection.mutable

   val stack: mutable.Stack[Short] = mutable.Stack()

   for (c <- s) {
     if (c == '(') {
       stack.push(0)
     } else {
       if (stack.nonEmpty) {
         stack.pop
       } else {
         return 0
       }
     }
   }
   if (stack.isEmpty) 1 else 0
 }
}
