package solution


object Fish {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    import scala.collection.mutable
    val fishStack: mutable.Stack[Int] = mutable.Stack()
    var count = 0
    var currentDirection = -1

    val lastDown = b.lastIndexWhere(_ == 0)
    val fishAndDirection = if (lastDown == -1) {
      a.zip(b)
    } else {
      count += a.length - lastDown - 1
      a.zip(b).dropRight(count)
    }

    for ((fish, direction) <- fishAndDirection) {
      if (currentDirection == -1) {
        if (direction == 0) {
          count += 1
        } else {
          currentDirection = 1
          fishStack.push(fish)
        }
      } else {
        if (direction == currentDirection) {
          fishStack.push(fish)
        } else if (currentDirection == 0 && direction == 1) {
          count += fishStack.length
          fishStack.clear
          fishStack.push(fish)
          currentDirection = direction
        } else {
          var lose = false
          while (fishStack.nonEmpty && !lose) {
            if (!lose) {
              if (fishStack.head < fish) {
                fishStack.pop
              } else {
                lose = true
              }
            }
          }
          if (!lose) {
            fishStack.push(fish)
            currentDirection = direction
          }
        }
      }
    }
//    println(count)
//    println(fishStack)
    count + fishStack.length
  }

//  def solutionFailed(a: Array[Int], b: Array[Int]): Int = {
//    import scala.collection.mutable
//    if (a.length == 1) { return 1 }
//
//    if (a.length == 100) { println(b.mkString(",")) }
//    val downStreamStack: mutable.Stack[Int] = mutable.Stack()
//    val upStreamStack: mutable.Stack[Int] = mutable.Stack()
//
//    val startIndex = b.indexWhere(_ == 1)
//
//    if (startIndex == -1) { return a.length }
//
//    val endIndex = b.lastIndexWhere(_ == 0)
//
//    if (endIndex == -1) { return a.length }
//
//    val fishAndDirection = a.zip(b).slice(startIndex, endIndex + 1)
//
//    for ((fish, dir) <- fishAndDirection) {
//      if (dir == 1) {
//        downStreamStack.push(fish)
//      }
//    }
//    for ((fish, dir) <- fishAndDirection.reverse) {
//      if (dir == 0) {
//        upStreamStack.push(fish)
//      }
//    }
//
//    while (downStreamStack.nonEmpty && upStreamStack.nonEmpty) {
//      if (downStreamStack.head < upStreamStack.head) {
//        downStreamStack.pop
//      } else {
//        upStreamStack.pop
//      }
//    }
//
//    println(downStreamStack)
//    println(upStreamStack)
//    startIndex + (a.length - endIndex - 1) + downStreamStack.length + upStreamStack.length
//  }


}
