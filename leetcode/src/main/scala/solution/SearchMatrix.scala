package solution

object SearchMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    case class CellIndexRange(top: Int, left: Int, bottom: Int, right: Int) {
      val height: Int = bottom - top + 1
      val width: Int = right - left + 1
    }

    val cellIndexRange = CellIndexRange(0, 0, matrix.length - 1, matrix.head.length - 1)

    def search(cellIndexRange: CellIndexRange): Boolean = {
      if (
        matrix(cellIndexRange.top)(cellIndexRange.left) == target ||
          matrix(cellIndexRange.bottom)(cellIndexRange.right) == target
      ) {
        true
      } else if (
        matrix(cellIndexRange.top)(cellIndexRange.left) > target ||
          matrix(cellIndexRange.bottom)(cellIndexRange.right) < target
      ) {
        false
      } else {
        val cellCountToCheck = Math.min(cellIndexRange.width, cellIndexRange.height) - 1
        if (cellCountToCheck > 0) {
          if (matrix(cellIndexRange.top + cellCountToCheck)(cellIndexRange.left + cellCountToCheck) == target) {
            return true
          }
          for (index <- 0 until cellCountToCheck) {
            if (matrix(cellIndexRange.top + index)(cellIndexRange.left + index) == target) {
              return true
            } else if (
              matrix(cellIndexRange.top + index)(cellIndexRange.left + index) < target &&
                matrix(cellIndexRange.top + index + 1)(cellIndexRange.left + index + 1) > target
            ) {
              return search(CellIndexRange(
                cellIndexRange.top,
                cellIndexRange.left + index + 1,
                cellIndexRange.top + index,
                cellIndexRange.right)) ||
                search(CellIndexRange(
                  cellIndexRange.top + index + 1,
                  cellIndexRange.left,
                  cellIndexRange.bottom,
                  cellIndexRange.left + index
                  ))
            }
          }
        }
        if (cellIndexRange.width > cellIndexRange.height) {
          return search(CellIndexRange(
            cellIndexRange.top,
            cellIndexRange.left + cellCountToCheck + 1,
            cellIndexRange.bottom,
            cellIndexRange.right
            ))
        }
        if (cellIndexRange.width < cellIndexRange.height) {
          return search(CellIndexRange(
            cellIndexRange.top + cellCountToCheck + 1,
            cellIndexRange.left,
            cellIndexRange.bottom,
            cellIndexRange.right
            ))
        }
        false
      }
    }

    search(cellIndexRange)
  }
}
