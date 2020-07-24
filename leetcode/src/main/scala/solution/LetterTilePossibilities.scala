package solution

object LetterTilePossibilities {
  object Solution {
    val factorial = Map(
      1 -> 1,
      2 -> 2,
      3 -> 6,
      4 -> 24,
      5 -> 120,
      6 -> 720,
      7 -> 5040,
    )
    def removeOne(tileNums: Array[Int]): Array[Array[Int]] = {
      tileNums.zipWithIndex.filter {
        case (tileNum, _) => tileNum > 0
      }.flatMap {
        case (tileNum, index) =>
          Array(tileNums) ++ (
            if (tileNum == 0)
              Array.empty[Array[Int]]
            else
              removeOne(tileNums.zipWithIndex.map {
                case (tileNum, i) =>
                  if (index == i) tileNum - 1
                  else tileNum
              })
          )
      }
    }

    def numTilePossibilities(tiles: String): Int = {
      val tileMap = scala.collection.mutable.Map[Char, Int]()
      tiles.foreach(char => {
        tileMap.get(char) match {
          case Some(_) => tileMap(char) = tileMap(char) + 1
          case None    => tileMap(char) = 1
        }
      })

      removeOne(tileMap.values.toArray).foldLeft(Array[Array[Int]]()) { (acc, nums) =>
        if (acc.exists(_ sameElements nums)) acc
        else acc :+ nums
      }.map {
        tileNums => factorial(tileNums.sum) / tileNums.filter(_ > 0).map(factorial(_)).product
      }.sum
    }
  }
}
