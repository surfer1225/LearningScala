package Test

/**
  * Created by Ryan on 6/6/2017 AD.
  */
import org.scalatest.FunSuite

class ReverseStringQueueTest extends FunSuite {
  test("get is invoked on an non-empty reverse String queue") {
    val q = new ReverseStrQueue
    q.put("abc")
    assert("cba" === q.get())
    assert(q.isEmpty)
  }
}
