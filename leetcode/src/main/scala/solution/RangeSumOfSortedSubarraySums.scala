package solution

object RangeSumOfSortedSubarraySums {

  object Solution {
    def rangeSum(nums: Array[Int], n: Int, left: Int, right: Int): Int = {
      val d = 1000000007
      val numbers = scala.collection.mutable.ArrayBuffer[Int]()
      var prevN = -1
      (0 until n).foreach {
        i =>
          (i until n).foreach {
            j =>
              if (j == i) {
                prevN = nums(j)
              } else {
                prevN = prevN + nums(j)
              }
              numbers.append(prevN)
          }
      }
      numbers.toArray.sorted.slice(left - 1, right).sum % d
    }
  }

}
