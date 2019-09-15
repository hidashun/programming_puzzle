package solution

import org.scalatest.FunSuite

import scala.util.Random

class FishTest extends FunSuite {

  test("testSolution1") {
    assert(Fish.solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)) == 2)
  }

  test("testSolution2") {
    assert(Fish.solution(Array(1), Array(0)) == 1)
  }

  test("testSolution3") {
    assert(Fish.solution(Array(1000000000), Array(1)) == 1)
  }

  test("testSolution4") {
    assert(Fish.solution(Array(0, 1), Array(1, 1)) == 2)
  }

  test("testSolution5") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(0, 0)) == 2)
  }

  test("testSolution6") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(1, 0)) == 1)
  }

  test("testSolution7") {
    assert(Fish.solution(Array(1000000000, 999999999), Array(0, 1)) == 2)
  }

  test("testSolution8") {
    assert(Fish.solution(Array(999999999, 1000000000), Array(1, 0)) == 1)
  }

  test("testSolution9") {
    assert(Fish.solution(Array(8, 6, 5, 3, 2, 4, 7), Array(1, 1, 1, 0, 0, 1, 1)) == 5)
  }

  test("testSolution10") {
    assert(Fish.solution(Array(8, 6, 5, 3, 2, 4, 7), Array(1, 1, 1, 1, 1, 0, 0)) == 1)
  }

  test("testSolution11") {
    assert(Fish.solution(Array(8, 6, 4, 2, 1, 3, 5), Array(1, 1, 1, 1, 1, 0, 0)) == 2)
  }

  test("testSolution12") {
    assert(Fish.solution(
      Array(60784,686946,40022,400519,657473,336999,36846,8629,915034,998496,924250,822568,619077,276547,241586,673773,30494,74609,18604,810348,983816,474571,222168,696835,810107,549971,142600,281896,987134,690593,476768,58824,508926,51353,771919,511351,976304,595971,178049,967459,234972,363128,90978,112527,28143,663596,905973,818820,946713,388246,363322,404614,344178,6674,661321,621452,955892,162267,312541,418840,476262,341790,208793,423207,558190,958749,364193,356345,636930,666411,135069,268254,601457,52058,459262,440055,145302,167563,113832,770673,481024,374754,842404,912042,690115,189232,102613,726328,815698,171214,500012,384581,427243,163524,518997,748528,695896,274048,10860,430154),
      Array(0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,1,1,1,1,0,0,1,1,0,0,0,1,1,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,1,0,0,1,0,0,0,0,1,1,1)
    ) == 16)
  }

  test("testSolution13") {
    assert(Fish.solution(Array(1, 3, 4, 5, 6, 7, 2), Array(0, 1, 1, 1, 1, 0, 1)) == 3)
  }

  test("testSolution15") {
    assert(Fish.solution(Array(2, 6, 7, 8, 4, 3, 5), Array(0, 0, 1, 0, 1, 0, 0)) == 4)
  }

//  test("testSolution14") {
//    val baseSeq = Seq(2, 3, 4, 5, 6, 7, 8)
//    val dirSeq = (0 to 6).map(_ => Random.nextInt(2))
//
//    val seqA = Random.shuffle(baseSeq).toArray
//    val dirA = dirSeq.toArray
//    val seqB = seqA.reverse.toArray
//    val dirB = dirA.reverse.map(v => if (v == 0) 1 else 0)
//
//    println(seqA.mkString(","))
//    println(dirA.mkString(","))
//    assert(Fish.solution(seqA, dirA) == Fish.solution(seqB, dirB))
//  }
}
