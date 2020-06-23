package solution


object QueriesOnAPermutationWithKey {
  import scala.annotation.tailrec
  object Solution {
    def processQueries(queries: Array[Int], m: Int): Array[Int] = {
      val p = (1 to m).toArray

      @tailrec
      def process(queries: List[Int], p: Array[Int], result: Array[Int]): Array[Int] = {
       queries match {
         case queried :: left =>
           val index = p.indexOf(queried)
           process(left, (queried +: p.slice(0, index)) ++ p.slice(index + 1, p.length), result :+ index)
         case Nil => result
       }
      }
      process(queries.toList, p, Array.empty[Int])
    }
  }
}
