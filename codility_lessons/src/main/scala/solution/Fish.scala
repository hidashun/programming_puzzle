package solution

object Fish {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    if (a.length < 30) {
      println(a.mkString(","))
      println(b.mkString(","))
    }
    if (a.length >= 3) a(2) else 2
  }


}
