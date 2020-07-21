package solution

object PartitionLabels {
  object Solution {
    def partitionLabels(S: String): List[Int] = {
      val startMap = scala.collection.mutable.Map[Char, Int]()
      val endMap   = scala.collection.mutable.Map[Char, Int]()
      S.zipWithIndex.foreach { case (char, i) =>
        startMap.get(char) match {
          case Some(_) =>
            endMap(char) = i
          case None =>
            startMap.addOne(char, i)
            endMap.addOne(char, i)
        }
      }

      val startAndEndArray = scala.collection.mutable.ArrayBuffer[(Int, Int)]()
      startMap.toSeq.sortBy(_._2).foreach { case (char, start) =>
        val end  = endMap(char)
        val overlapped = startAndEndArray.indexWhere { case (_, otherEnd) =>
          start < otherEnd
        }
        if (-1 < overlapped) {
          if (startAndEndArray(overlapped)._2 < end) {
            startAndEndArray(overlapped) = (startAndEndArray(overlapped)._1, end)
          }
        } else {
          startAndEndArray.addOne((start, end))
        }
      }
      startAndEndArray.map { case (s, e) => e - s + 1 }.toList
    }
  }
}
