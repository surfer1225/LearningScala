package Test

/**
  * Created by Ryan on 6/7/2017 AD.
  */
import org.scalatest.FunSuite

class DoubleCompareTest extends FunSuite {
  test("compare values bet/w 2 doubles") {
    implicit def add_(d: Double) = new withAlmostEquals(d)
    implicit val precision = Precision(0.001)
    assert(3.0002~=3.0001)
  }
}
