package Test

import org.scalatest.FunSuite

/**
  * Created by Ryan on 6/8/2017 AD.
  */
class OptionTest extends FunSuite {
  test ("test get first not-none value") {
    val getOption = new GetOption
    assert(getOption.getNotNone(None, None, 'a', None) === 'a')
  }
}
