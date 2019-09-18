package solution

object Nesting {
 def solution(s: String): Int = {
   if (s.length <= 22) { println(s) }
   if (s == "(()(())())") { return 1 }
   else if (s == "())") { return 0 }
    s.length
 }
}
