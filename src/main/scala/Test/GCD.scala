package Test

import scala.annotation.tailrec

/**
  * Created by Ryan on 6/7/2017 AD.
  */
class GCD {
  @tailrec//assuming a != 0
  final def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
