package ClassExample

/**
  * Created by Ryan on 6/6/2017 AD.
  */
trait Buffer {
  type T
  val element: T
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}

object TestAbstract {
  def main(args: Array[String]): Unit = {
    def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
      new IntSeqBuffer {
        type T = List[U]
        val element = List(elem1, elem2)
      }
    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
  }
}