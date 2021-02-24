package util

import scala.collection.mutable.ArrayBuffer
import scala.util.{Success, Try}

class Helper() {
  def getReadLine(list: String*): () => String = {
    val iter = LazyList.from(list).iterator
    () => {
      Try(iter.next()) match {
        case Success(value) => value
        case _ => null
      }
    }
  }
  
  val output: ArrayBuffer[String] = ArrayBuffer.empty

  val myPrintln: String => output.type = (str: String) => {
    output.append(str)
  }
}
