package solution

object Triangle {
  def solution(a: Array[Int]): Int = {
    val sortedA = a.sorted
    var count = 0
    for (index <- (0 until sortedA.length - 2)) {
      if (sortedA(index) + sortedA(index + 1) >= sortedA(index + 2)) {
        count += 1
      }
    }
    count
  }
}
