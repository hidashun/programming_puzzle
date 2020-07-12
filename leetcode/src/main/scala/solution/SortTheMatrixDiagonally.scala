package solution


object SortTheMatrixDiagonally {
  object Solution {
    import scala.annotation.tailrec
    import scala.collection.mutable.ArrayBuffer

    @tailrec
    def traverse(x: Int, y: Int, m: Int, n: Int, result: Seq[(Int, Int)]): Seq[(Int, Int)] = {
      if (x + 1 < n && y + 1 < m) {
        traverse(x + 1, y + 1, m, n, result :+ (x + 1, y + 1))
      } else result
    }

    def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
      val m = mat.length
      val n = mat.head.length
      val result = ArrayBuffer.fill(m)(ArrayBuffer.fill(n)(0))

      val indiceSeq = (0 to n - 2).map {
        currentN =>
          traverse(currentN, 0, m, n, Seq((currentN, 0)))
      } ++ (1 to m - 2).map {
        currentM =>
          traverse(0, currentM, m, n, Seq((0, currentM)))
      }
      indiceSeq.foreach(indice =>
        indice.zip(indice.map { case (x, y) => mat(y)(x) }.sorted).foreach {
          case (index, value) => result(index._2)(index._1) = value
        }
      )

      result(0)(n - 1) = mat(0)(n - 1)
      result(m - 1)(0) = mat(m - 1)(0)

      result.map(_.toArray).toArray
    }
  }
}
