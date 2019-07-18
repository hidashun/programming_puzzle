import scala.collection.mutable
// simple large positive test, 100K ('s followed by 100K )'s + )(
// 10K+1 ('s followed by 10K )'s + )( + ()

object Solution {
  def solutionStack(s: String): Int = {
    import scala.collection.mutable.ArrayBuffer
    var stack: mutable.Stack[Char] = mutable.Stack()

    var result = 1
    try {
      for (c <- s) {
        c match {
          case '{' | '[' | '(' => stack.push(c)
          case '}' => {
            if (stack.nonEmpty && stack.top == '{') {
              stack.pop
            } else {
              throw new Exception
            }
          }
          case ']' => {
            if (stack.nonEmpty && stack.top == '[') {
              stack.pop
            } else {
              throw new Exception
            }
          }
          case ')' => {
            if (stack.nonEmpty && stack.top == '(') {
              stack.pop
            } else {
              throw new Exception
            }
          }
        }
      }
    } catch {
      case _: Exception => result = 0
    }
    if (stack.isEmpty) result else 0
  }

  def solutionDominator(a: Array[Int]): Int = {
    var n = a.length
    var size = 0
    var value = -1
    for (k <- 0 until n) {
      if (size == 0) {
        size += 1
        value = a(k)
      } else {
        if (value != a(k)) {
          size -= 1
        } else {
          size += 1
        }
      }
    }

    var candidate = -1
    if (size > 0) {
      candidate = value
    }
    var leader = -1
    var count = 0
    var where = -1
    for (k <- 0 until n) {
      if (a(k) == candidate) {
        if (where == -1) {
          where = k
        }
        count += 1
      }
    }
    if (count > n / 2) {
      where
    } else {
      -1
    }
  }

  def solutionPermMissingElem(a: Array[Int]): Int = {
    if (a.length == 0) {
      return 1
    }
    val sortedA = a.sorted
    if (sortedA.last != a.length + 1) {
      return a.length + 1
    }
    var current = 1
    for (i <- sortedA) {
      if (current == i) {
        current += 1
      } else {
        return current
      }
    }
    -1
  }

  def solutionMaxProfit(a: Array[Int]): Int = {
    if (a.length == 0) {
      return 0
    }
    var acc = 0
    var maxMemo = 0
    for (i <- 1 until a.length) {
      val diff = a(i) - a(i - 1)
      val accumlated = diff + acc
      if (diff > accumlated) { acc = diff }
      else { acc = diff + acc }
      if (acc > maxMemo) { maxMemo = acc}
    }
    maxMemo
  }


  def solutionA(n: Int): Int = {
    import scala.annotation.tailrec
    @tailrec
    def search(n: Int, maxCandidate: Int, check: Int, factors: Int): (Int, Int, Int, Int) = {
      if (check < maxCandidate) {
        val newCheck = check + 1
        var newMaxCandidate = maxCandidate
        var newFactors = factors
        if (n % newCheck == 0) {
          newFactors = factors + (if (n / newCheck == newCheck) {
            1
          } else {
            2
          })
          newMaxCandidate = n / newCheck - 1
        }
        search(n, newMaxCandidate, newCheck, newFactors)
      } else {
        (n, maxCandidate, check, factors)
      }
    }

    if (n == 1) { return 1 }
    val maxCandidate = n / 2
    val check = 1
    val factors = 2
    val (_, _, _, result) = search(n, maxCandidate, check, factors)
    result
  }

  def solutionB(n: Int): Int = {
    if (n == 1) { return 1 }
    var maxCandidate = n / 2
    var check = 1
    var factors = 2

    while (check < maxCandidate) {
//      println(check)
      check += 1
      if (n % check == 0) {
        factors += (if (n / check == check) {
          1
        } else {
          2
        })
        maxCandidate = n / check - 1
      }
    }
    factors
  }

  def solutionCountFactors(n: Int): Int = {
    if (n == 1) { return 1 }

    def isPrime(x: Int): Boolean = {
      for (i <- 2 to Math.sqrt(x).toInt + 1) {
        if (n % i == 0) {
          return false
        }
      }
      true
    }
    if (isPrime(n)) { return 2 }

    var maxCandidate = n / 2
    var check = 1
    var factors = 2

    while (check < maxCandidate) {
      check += 1
      if (n % check == 0) {
        factors += (if (n / check == check) { 1 } else { 2 })
        maxCandidate = n / check - 1
      }
    }
    factors
  }

  def solutionTapeEquilibrium(a: Array[Int]): Int = {
    if (a.length == 2) {
      return Math.abs(a(0) - a(1))
    }
    val s = a.sum
    var candidate = 2000 * 100000
    var acc = 0
    for (i <- 0 until a.length - 1) {
      acc = acc + a(i)
      val tmp = Math.abs(acc * 2 - s)
      candidate = if (tmp < candidate) { tmp } else { candidate }
    }
    candidate
  }

  def solutionMaxDoubleSliceSum(a: Array[Int]): Int = {
    val maxSumEnd   = Array.fill(a.length)(0)
    val maxSumStart = Array.fill(a.length)(0)

    for (i <- 1 to a.length - 2) {
      maxSumEnd(i)   = Math.max(0, maxSumEnd(i - 1)   + a(i))
    }
    for (i <- (a.length - 2) to 1 by -1) {
      maxSumStart(i) = Math.max(0, maxSumStart(i + 1) + a(i))
    }

    var maxSum = 0
    for (i <- 1 to a.length - 2) {
      val candidate = maxSumEnd(i - 1) + maxSumStart(i + 1)
      if (maxSum < candidate) { maxSum = candidate }
    }

    maxSum
  }
}


object Main extends App {
//    var result = Solution.solution(24)
//  var result = Solution.solution(Array(2, -5, 3, -4, 1))
//  var result = Solution.solution(Array(-1000, 1000))
//  var result = Solution.solutionTapeEquilibrium(Array(12, -5, -7, -2, 10))
    var result = Solution.solutionMaxDoubleSliceSum(Array(3, 2, 6, -1, 4, 5, -1, 2))
//var result = Solution.solutionMaxDoubleSliceSum(Array(-2, -3, -4, 1, -5, -6, -7))
//  var result = Solution.solutionMaxDoubleSliceSum(Array(5, 17, 0, 3))

  // 262
// var result = Solution.solutionMaxDoubleSliceSum(Array(-27,-25,-6,-24,24,-28,2,-10,21,-21,-10,-10,-16,-30,-4,-25,6,-26,-11,-3,25,-25,-22,18,-29,25,4,-14,21,16,-10,18,-18,7,2,19,-11,-6,16,1,11,8,10,24,-1,10,-8,-29,16,-19,20,25,10,-20,-10,-7,-26,-3,4,-10,-19,-25,8,-30,-9,-17,2,14,25,8,30,28,8,-16,-1,-20,30,-3,15,-28,-22,-19,-15,-9,-14,-4,-5,-24,-27,-9,-25,-4,-30,2,-26,12,-6,30,-14,-2,15,-10,-9,8,29,23,-5,13,11,-8,-16,-26,23,-27,1,2,-22,10,25,17,-7,-23,29,1,8,18,-7,-27,-22,10,-9,23,15,29,10,-12,18,-29,1,23,1,-22,0,3,-8,24,-10,-14,0,-18,-11,-6,27,-26,-18,-18,30,24,-19,4,-25,-11,-10,2,26,19,2,17,-1,14,17,-15,20,5,-1,-6,-17,0,-23,8,24,18,7,0,12,-23,-27,22,-8,10,-5,-9,16,-10,15,20,-19,29,-27,-5,0,20,-20,4,-8,26,-23,-14,20,-11,27,-27,-7,-24,4,28,-11,9,-14,-4,4,-15,12,0,25,-14,28,-19,-29,10,14,-1,-28,30,-22,23,24,-17,22,-2,24,24,17,-13,5,29,-11,-7,11,-27,-15,-20,-5,-5,7,0,-20,-28,2,16,26,21,-12,22,-2,-13,-25,-3,3,-13,-19,27,-26,27,-6,18,-24,4,16,-4,-9,0,-19,-18,-16,-28,25,-26,26,-30,10,3,-28,27,14,23,-4,-13,-19,-24))

//  var result = Solution.solution(Array(-10, -20, -30, -40, 100))
//  var result = Solution.solution(Array(3, 1, 2, 4, 3))
    println(result)
//  var result = Solution.solution(1000000000)
//  println(result)
//  result = Solution.solution(780291637)
//  println(result)
//  result = Solution.solution(449991369)
//  println(result)
//  result = Solution.solution(479001600)
//  println(result)
//  result = Solution.solution(2147395600)
//  println(result)
//  result = Solution.solution(2147483647)
//  println(result)
}

/*
100
2
15
792
135
2

2147483647 / 2
 */
