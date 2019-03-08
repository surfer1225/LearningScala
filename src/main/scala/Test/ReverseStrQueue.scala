package Test

/**
  * Created by Ryan on 6/6/2017 AD.
  */
trait ReverseStrQueueTrait extends Queue[String] {
  abstract override def put(x: String) { super.put(x.reverse) }
}

class ReverseStrQueue extends StringQueue with ReverseStrQueueTrait
