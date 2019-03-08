package ConceptTrial

import scala.concurrent.Future
import scala.util.Try
import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by Ryan on 13/6/17.
  */
object ThreadTrial extends App {
  def sleep(millis: Long) = {
    Thread.sleep(millis)
  }

  // task
  def doWork(index: Int) = {
    sleep((math.random * 1000).toLong)
    index
  }

  (Range(1, 6)) foreach { index =>
    val future = Future {
      doWork(index)
    }
    future onComplete {
      case answer: Try[Int] => println(s"Success! returned: ${answer}")
      case th: Throwable => println(s"Failure! returned: $th")
    }
  }

  sleep(1000)

  println("Finito!")
}
