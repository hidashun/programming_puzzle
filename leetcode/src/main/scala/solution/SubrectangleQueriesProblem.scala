package solution

import scala.collection.mutable

object SubrectangleQueriesProblem {
  class SubrectangleQueries(_rectangle: Array[Array[Int]]) {
    def updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int): Unit = {
      for {
        row <- row1 to row2
        col <- col1 to col2
      } {
       _rectangle(row)(col) = newValue
      }
    }

    def getValue(row: Int, col: Int): Int = {
      _rectangle(row)(col)
    }
  }

  def run(_rectangle: Array[Array[Int]], commands: Seq[String], params: Array[Array[Int]]): Array[Option[Int]] = {
    val obj = new SubrectangleQueries(_rectangle)
    val result = mutable.ArrayBuffer[Option[Int]](None)
    commands.zip(params).foreach {
      case (command, param) => {
        command match {
          case "getValue" =>
            result.append(Some(obj.getValue(param(0), param(1))))
          case "updateSubrectangle" =>
            obj.updateSubrectangle(param(0), param(1), param(2), param(3), param(4))
            result.append(None)
        }
        println(command)
        println(param)
      }
    }
    result.toArray
  }
}
