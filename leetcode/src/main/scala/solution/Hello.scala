package solution

import util.Helper

//import scala.io.StdIn.readLine

object Hello {
  def hello(args: Array[String]): Helper = {
    val helper = new Helper
    val readLine = helper.getReadLine("3", "Hello")
    val println = helper.myPrintln

    val count = readLine().toInt
    val text = readLine()
    (0 until count).foreach(_ => println(text))

    helper
  }
}
