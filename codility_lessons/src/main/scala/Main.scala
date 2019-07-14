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
}


object Main extends App {
//    var result = Solution.solution(24)
//  var result = Solution.solution(Array(2, -5, 3, -4, 1))
//  var result = Solution.solution(Array(-1000, 1000))
  var result = Solution.solutionTapeEquilibrium(Array(12, -5, -7, -2, 10))
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
