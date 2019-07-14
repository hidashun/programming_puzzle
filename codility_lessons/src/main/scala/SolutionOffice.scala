//import scala.collection.mutable
//import scala.collection.mutable.ArrayBuffer

object SolutionOffice {
  //  def solutionDistinct(a: Array[Int]): Int = {
  //    a.distinct.length
  //  }
  //
  //  def solutionDistinct2(a: Array[Int]): Int = {
  //    val sortedA = a.sorted
  //    val threePlus = sortedA.slice(sortedA.length - 3, sortedA.length).product
  //    val twoWorstAndBest = sortedA.slice(0, 2).product * sortedA.last
  //    Math.max(threePlus, twoWorstAndBest)
  //    math.max(threePlus, twoWorstAndBest)
  //  }
  //
  //  def solutionStack(s: String): Int = {
  //    var stack: ArrayBuffer[Char] = ArrayBuffer.empty
  //
  //    var result = 1
  //    try {
  //      for (c <- s) {
  //        c match {
  //          case '{' | '[' | '(' => stack.append(c)
  //          case '}' => {
  //            stack.lastOption match {
  //              case Some(b) if b == '{' => {
  //                stack =stack.dropRight(1)
  //              }
  //              case None => throw new Exception
  //            }
  //          }
  //          case ']' => {
  //            stack.lastOption match {
  //              case Some(b) if b == '[' => {
  //                stack = stack.dropRight(1)
  //              }
  //              case None => throw new Exception
  //            }
  //          }
  //          case ')' => {
  //            stack.lastOption match {
  //              case Some(b) if b == '(' => {
  //                stack = stack.dropRight(1)
  //              }
  //              case None => throw new Exception
  //            }
  //          }
  //        }
  //      }
  //    } catch {
  //      case _: Throwable => result = 0
  //    }
  //    if (stack.isEmpty) result else 0
  //  }
  //
  //  def solutionDominator(a: Array[Int]): Int = {
  //    val stack = mutable.Stack[Int]()
  //    var indexMap: Map[Int, Int] = Map.empty
  //
  //    for ((n, i) <- a.zipWithIndex) {
  //      if (!indexMap.contains(n)) {
  //        indexMap = indexMap + (n -> i)
  //      }
  //
  //      if (stack.isEmpty) {
  //        stack.push(n)
  //      } else {
  //        if (stack.top == n) {
  //          stack.push(n)
  //        } else {
  //          stack.pop
  //        }
  //      }
  //    }
  //    if (stack.isEmpty) {
  //      -1
  //    } else {
  //      indexMap(stack.top)
  //    }
  //  }

  def solutionSlow(a: Array[Int]): Int = {
    if (a.length == 0) {
      return 0
    }
    val memo = Array.fill[Int](a.length)(0)
    var maxCandidate = 0
    for (dayIndex <- 1 until a.length) {
      val profit = a(dayIndex) - a(dayIndex - 1)

      for (j <- 0 until dayIndex) {
        memo(j) = memo(j) + profit
        if (memo.max > maxCandidate) {
          maxCandidate = memo.max
        }
      }
    }
    //    println(memo.mkString(", "))
    maxCandidate
  }

  //  def solutionMaxprofit(a: Array[Int]): Int = {
  //    if (a.length == 0) {
  //      return 0
  //    }
  //    val memo = Array.fill[Int](a.length)(0)
  //    var maxCandidate = 0
  //    for (dayIndex <- 1 until a.length) {
  //      val profit = a(dayIndex) - a(dayIndex - 1)
  //
  //      memo(dayIndex) = if (profit > maxCandidate) { profit }
  //    }
  ////    println(memo.mkString(", "))
  //    maxCandidate
  //  }

  def divN(f: Int, d: Int, n: Int, count: Seq[Int]): (Int, Int, Seq[Int]) = {
    if (n % d == 0) {
      divN(f, d, n / d, count :+ n / d)
    } else {
      if (f < n) {
        divN(f, d + 1, n, count)
      } else {
        (d, n, count)
      }
    }
  }

  //  def solution(n: Int): Int = {
  //    val (a, b, c) = divN(n, 1, n, Seq())
  //    println(divN(n, 1, n, Seq()))
  ////    (1 to n).count(x => n % x == 0)
  //    println(a, b, c)
  //    8
  //  }

  def solutionSlow2(a: Array[Int]): Int = {
    (1 until a.length).map(i => Math.abs(a.slice(0, i).sum - a.slice(i, a.length).sum)).min
  }

  def solutionTapeEquilibriumTokenakattayatus(a: Array[Int]): Int = {
    var acc = 0
    val s = a.sum
    val half = s / 2

    def tmp(): Int = {
      for (n <- a) {
        acc = acc + n
        if (half - acc < 0) {
          return half - acc
        }
      }
      acc
    }

    Math.abs(tmp)
  }

  def solution(h: Array[Int]): Int = {
    import scala.collection.mutable
    val stack = mutable.Stack[Int]()
    var wallCount = 0
    for (height <- h) {
      if (stack.isEmpty) {
        stack.push(height)
        wallCount = wallCount + 1
      } else {
        if (stack.head > height) {
          while (stack.nonEmpty && stack.head > height) {
            stack.pop()
          }
        }
        if (stack.isEmpty || (stack.nonEmpty && stack.head != height)) {
          stack.push(height)
          wallCount = wallCount + 1
        }
      }
    }
    wallCount
  }
}

//object Main extends App {
////  val result = Solution.solution(Array(3, 4, 3, 2, 3, -1, 3, 3))
//  val result = Solution.solution(Array(8, 8, 5, 7, 9, 8, 7, 4, 8))
////  val result = Solution.solution(Array(8, 9, 3, 6, 1, 2))
//  println(result)
//}


/*
8
8

minus



39916800 / 2
19958400, 2
9979200
9979200, 2, 2
49989600, 2, 2, 2
24994800, 2, 2, 2, 2
12497400, 2, 2, 2, 2, 2

13 - 3 10


3
1 -2
2 -2
4
3 0

1
-5
3




1
2
3
4 2 * 2
6 3 * 2
8 2 * 2 * 2
12 (3 * 2) * 2
24 3 * 2 * 2 * 2
 */
