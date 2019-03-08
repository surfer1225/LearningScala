package Test

import org.scalatest.FunSuite

/**
  * Created by Ryan on 6/8/2017 AD.
  */


class SquareListTest extends FunSuite{
  test("test square list of int - Method 1") {
    val sl = new SquareList
    assert(sl.squareMapList(List(1, 2, 3)) === List(1, 4, 9))
  }

  test("test square list of int - Method 2") {
    val sl = new SquareList
    assert(sl.squareList(List(1, 2, 3)) === List(1, 4, 9))
  }
}
