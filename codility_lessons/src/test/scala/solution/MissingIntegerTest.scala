package solution

import org.scalatest.FunSuite

class MissingIntegerTest extends FunSuite {

  test("testSolution 0") {
    assert(MissingInteger.solution(Array(1, 3, 6, 4, 1, 2)) == 5)
  }

  test("testSolution 1") {
    assert(MissingInteger.solution(Array(1, 2, 3)) == 4)
  }

  test("testSolution 2") {
    assert(MissingInteger.solution(Array(-1, -3)) == 1)
  }

  test("testSolution 3") {
    assert(MissingInteger.solution(Array(1)) == 2)
  }

  test("testSolution 4") {
    assert(MissingInteger.solution(Array(2)) == 1)
  }

  test("testSolution 5") {
    assert(MissingInteger.solution(Array(0)) == 1)
  }

  test("testSolution 6") {
    assert(MissingInteger.solution(Array(-1)) == 1)
  }

  test("testSolution 7") {
    assert(MissingInteger.solution(Array(4, 5, 6, 2)) == 1)
  }

  test("testSolution 8") {
    assert(MissingInteger.solution(Array(4, 1, 5, 6, 2)) == 3)
  }

  test("testSolution 9") {
    assert(MissingInteger.solution(Array(90, 91, 92, 93)) == 1)
  }

  test("testSolution 10") {
    assert(MissingInteger.solution(Array(-1000000, 1000000)) == 1)
  }

  test("testSolution 11") {
    assert(MissingInteger.solution(Array(1, 2, 3, 1, 1, 2, 4, 5, -1000000, 1000000)) == 6)
  }

  test("testSolution 12") {
    assert(MissingInteger.solution(Array(116,125,198,83,0,91,52,189,54,34,92,115,1,25,165,36,141,24,124,173,80,73,95,159,4,61,3,156,28,121,148,31,76,119,122,15,72,49,26,171,81,57,10,35,117,55,40,11,161,192,130,188,12,152,43,135,62,162,111,102,140,13,59,178,160,158,32,176,17,200,145,170,150,167,71,41,181,114,154,7,42,86,82,77,68,63,106,110,120,127,69,191,21,14,90,139,46,5,79,23,197,185,53,155,112,9,194,22,51,157,2,8,142,179,174,58,199,37,143,98,65,153,182,85,105,164,94,93,131,87,109,38,187,30,19,184,113,50,186,104,132,196,75,163,78,99,169,84,48,128,175,183,100,56,96,44,107,64,103,137,151,74,39,33,29,6,190,180,118,149,195,177,168,129,126,97,144,134,108,133,16,136,70,146,47,67,89,45,138,27,60,123,166,18,172,147,88,20,193,66)) == 101)
  }

  test("testSolution 13") {
    assert(MissingInteger.solution(Array(127,118,149,125,145,106,148,131,123,101,105,124,128,144,141,115,108,120,126,111,147,114,135,109,136,113,102,146,130,132,104,140,103,112,134,143,122,138,129,121,110,133,100,137,107,139,119,116,142,117)) == 1)
  }

  test("testSolution 14") {
    assert(MissingInteger.solution(Array(-84,-17,-71,-26,-95,-11,-79,-39,-100,-93,-37,-29,-53,-76,-57,-48,-18,-15,-19,-89,-58,-42,-10,-2,-96,-68,-66,-33,-45,-50,-77,-25,-82,-91,-75,-9,-56,-59,-43,-5,-36,-6,-40,-44,-61,-28,-16,-22,-81,-60,-47,-13,-12,-80,-8,-70,-35,-72,-41,-73,-78,-85,-97,-1,-31,-52,-24,-30,-63,-20,-67,-92,-87,-54,-62,-55,-49,-3,-99,-34,-14,-94,-65,-27,-86,-64,-51,-98,-4,-69,-7,-46,-83,-32,-74,-90,-38,-23,-88,-21)) == 1)
  }
}
