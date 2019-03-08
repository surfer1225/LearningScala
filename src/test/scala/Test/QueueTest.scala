package Test

/**
  * Created by Ryan on 6/6/2017 AD.
  */
import org.scalatest.FunSuite

class QueueTest extends FunSuite{
  test("get is invoked on an non-empty queue") {
    val q = new StringQueue
    q.put("aaa")
    q.put("bbb")
    assert("aaa" === q.get())
    assert("bbb" === q.get())
    assert(q.isEmpty)
  }

  test("get is invoked on an empty queue") {

    val q = new IntQueue
    intercept[IndexOutOfBoundsException] {
      q.get()
    }
    assert(q.isEmpty)
  }
}
