package Test

import org.scalatest.FunSuite

/**
  * Created by Ryan on 6/8/2017 AD.
  */

class MapListTest extends FunSuite {
  test ("test map list conversion") {
    val mapList = new MapListToList
    //println(mapList.convertList(List(1, 2, 3, 4), Map(1->3, 3->5)))
    assert(mapList.convertList(List(1, 2, 3, 4), Map(1->3, 3->5))===List(3,15))
  }
}
