package solution

object CountNumberOfTeams {
  // https://leetcode.com/problems/count-number-of-teams/
  object Solution {
    def numTeams(rating: Array[Int]): Int = {
      var count = 0
      (1 until rating.length).foreach {
        index => {
          val rate = rating(index)
          val beforeRating = rating.slice(0, index)
          val afterRating = rating.slice(index + 1, rating.length)

          val firstRatesAscend = beforeRating.count(_ < rate)
          val firstRatesDescend = beforeRating.length - firstRatesAscend
          val lastRatesAscend = afterRating.count(_ > rate)
          val lastRatesDescend = afterRating.length - lastRatesAscend

          count += firstRatesAscend * lastRatesAscend
          count += firstRatesDescend * lastRatesDescend
          ()
        }
      }
      count
    }
  }

}
