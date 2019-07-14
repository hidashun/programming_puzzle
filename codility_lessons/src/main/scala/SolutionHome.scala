object Lesson2CyclicRotationSolution {
def solution(a: Array[Int], k: Int): Array[Int] = {
val aLength = a.length
val headIndex = if (aLength == 0) { 0 } else { aLength - (k % aLength) }
a.slice(headIndex, aLength) ++ a.slice(0, headIndex)
}
}

import scala.collection.mutable.Set

object Lesson2OddOccurrencesInArray {
  def solution(a: Array[Int]): Int = {
    var unpaired: Set[Int] = Set.empty
    a.sorted.foreach { n =>
      if (unpaired.contains(n)) {
        unpaired -= n
      } else {
        unpaired += n
      }
    }
    unpaired.iterator.next
  }
}


object Lesson3FrogJmpSolution {
  def solution(x: Int, y: Int, d: Int): Int = {
    scala.math.ceil((y - x).toDouble / d).toInt
  }
}

object Lesson5GenomicRangeQuery {
  def solutionHeavy(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val originalGenome: Array[Byte] = s.map {
      case 'A' => 1.toByte
      case 'C' => 2.toByte
      case 'G' => 3.toByte
      case 'T' => 4.toByte
    }.toArray

    val minP = p.min
    val minQ = q.max
    val trimmedGenome = originalGenome.slice(minP, minQ + 1)
    val genomeMap: collection.mutable.Map[Int, Int] = collection.mutable.Map.empty

    var initial = trimmedGenome.head
    var currentIndex = 0
    val genome = scala.collection.mutable.ArrayBuffer(initial)
    for ((x, i) <- trimmedGenome.zipWithIndex) {
      if (initial != x) {
        currentIndex += 1
        initial = x
        genome += x
      }
      genomeMap += i + minP -> currentIndex
    }
    val genomeLength = genome.length

    val tmp: Array[Array[Byte]] = Array.fill[Array[Byte]](genomeLength)(Array.empty[Byte])

    for (i <- 0 until genomeLength) {
      tmp(i) = Array.fill[Byte](i + 1)(0.toByte)
      for (j <- 0 to i) {
        val hoge = if (j == 0) {
           genome(i)
        } else {
           math.min(tmp(i - 1)(j - 1), tmp(i)(j - 1)).toByte
        }
        tmp(i)(j) = hoge
      }
    }

//    println(genome)
//    println(genomeMap)
//    tmp.foreach { x => println(x.mkString(", ")) }

    (p zip q).map { x => tmp(genomeMap(x._2))(genomeMap(x._2) - genomeMap(x._1)).toInt }
  }

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val counterByGenome: Array[Array[Int]] = Array.fill[Array[Int]](s.length + 1)(Array.fill[Int](4)(0))
    counterByGenome(0)(0) = 0
    counterByGenome(0)(1) = 0
    counterByGenome(0)(2) = 0
    counterByGenome(0)(3) = 0
    for ((char, i) <- s.zipWithIndex) {
      if (0 < i) {
        counterByGenome(i + 1)(0) = counterByGenome(i)(0)
        counterByGenome(i + 1)(1) = counterByGenome(i)(1)
        counterByGenome(i + 1)(2) = counterByGenome(i)(2)
        counterByGenome(i + 1)(3) = counterByGenome(i)(3)
      }
      char match {
        case 'A' => counterByGenome(i + 1)(0) = if (i == 0) { 1 } else { counterByGenome(i)(0) + 1 }
        case 'C' => counterByGenome(i + 1)(1) = if (i == 0) { 1 } else { counterByGenome(i)(1) + 1 }
        case 'G' => counterByGenome(i + 1)(2) = if (i == 0) { 1 } else { counterByGenome(i)(2) + 1 }
        case 'T' => counterByGenome(i + 1)(3) = if (i == 0) { 1 } else { counterByGenome(i)(3) + 1 }
      }
    }

    val ans = for ((start, end) <- p zip q)
        yield counterByGenome(start).zip(counterByGenome(end + 1)).map(x => x._2 - x._1).indexWhere(_ > 0, 0) + 1
    counterByGenome.foreach { x => println(x.mkString(", ")) }
    ans
  }
}
//object Main extends App {
////  val result = Lesson5GenomicRangeQuery.solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6))
////    val result = Lesson5GenomicRangeQuery.solution(
////      new String(Array.fill(100000)('T')),
////      (0 to 49999).toArray,
////      (50000 to 99999).toArray
////    )
////  val result = Lesson5GenomicRangeQuery.solution("CAGCCTA", Array(5, 0), Array(5, 6))
////  val result = Lesson5GenomicRangeQuery.solution("CAGCCTA", Array(5), Array(5))
//  val result = Lesson5GenomicRangeQuery.solution("C", Array(0), Array(0))
//  for (line <- result) { println(line) }
//}


/*
A 1
C 2
G 3
T 4

2 1 3 2 2 4 1

  0 1 2 3 4 5 6
1:2 1 3 2 2 4 1
2:  1 1 2 2 2 1
3:    1 1 2 2 1
4:      1 1 2 1
5:        1 1 1
6:          1 1
7:            1
 */
