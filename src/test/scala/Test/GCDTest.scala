package Test

/**
  * Created by Ryan on 6/7/2017 AD.
  */
import org.scalatest.FunSuite

class GCDTest extends FunSuite {
  test("test GCD of 2 Int") {
    val gcdTest = new GCD
    assert(gcdTest.gcd(24, 36) === 12)
    assert(gcdTest.gcd(9, 12) === 3)
    assert(gcdTest.gcd(1, 1) === 1)
    assert(gcdTest.gcd(7, 13) === 1)
  }
}
