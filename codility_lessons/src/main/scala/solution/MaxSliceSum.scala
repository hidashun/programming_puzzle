package solution

object MaxSliceSum {
  def solution(a: Array[Int]): Int = {
    var maxEnding = 0
    var maxSlice  = 0
    var maxSingleValue = Int.MinValue

    for (i <- a.indices) {
      maxEnding = Math.max(0, maxEnding + a(i))
      maxSlice  = Math.max(maxSlice, maxEnding)
      maxSingleValue = Math.max(maxSingleValue, a(i))
    }

    if (maxSingleValue < 0) maxSingleValue else maxSlice
  }
}
