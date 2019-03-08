package Test

/**
  * Created by Ryan on 6/7/2017 AD.
  */

// to understand how implicit works
// to understand how type casting works
case class Precision(val p:Double)
class withAlmostEquals(d: Double) {
  def ~=(other: Double)(implicit precision: Precision) = (d - other).abs <= precision.p
}

object DoubleCompare extends App {
  implicit def add_(d: Double) = new withAlmostEquals(d)
  implicit val precision = Precision(0.001)

  def test(d: Double) = new withAlmostEquals(d)
  println(test(3.0002).~=(3.0001)(Precision(0.000001)))
  println(3.0002 ~= 3.0001)
}
