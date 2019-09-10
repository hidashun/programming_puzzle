package solution

object Triangle {
  def solution(a: Array[Int]): Int = {
    if (a.length == 3) { println(a.mkString(","))}
    val sortedA = a.sorted
    for (index <- (0 until sortedA.length - 2)) {
      if (0 < sortedA(index)) {
        val (p, q, r) = (sortedA(index), sortedA(index + 1), sortedA(index + 2))
        if (p == q && q == r) {
          return 1
        }
        if (p + q > r) {
          return 1
        }
      }
    }
    0
  }
}
