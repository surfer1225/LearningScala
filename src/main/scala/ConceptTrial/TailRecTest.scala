package ConceptTrial

import scala.util.control.TailCalls._


// trampoline data structure
object TailRecTest extends App {
  def isEven(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(isOdd(xs.tail))
  def isOdd(xs: List[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(isEven(xs.tail))
}
