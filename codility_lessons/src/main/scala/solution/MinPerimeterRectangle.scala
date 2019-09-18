package solution

object MinPerimeterRectangle {
  def solution(n: Int): Int = {
    import scala.collection.mutable

    def isPrime(x: Int): Boolean = {
      for (i <- 2 to Math.sqrt(x).toInt + 1) {
        if (n % i == 0) { return false }
      }
      true
    }
    if (isPrime(n)) { return (n + 1) * 2 }

    var maxCandidate = n / 2
    var check = 1
    var factors: mutable.Seq[Int] = mutable.Seq.empty

    while (check < maxCandidate) {
      check += 1
      if (n % check == 0) {
        print(s"${check}, ")
        factors = factors :+ (if (n / check == check) { check * 4 } else { (check + n / check) * 2 })
        maxCandidate = n / check - 1
      }
    }

    factors.min
  }
}
