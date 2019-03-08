package Test

/**
  * Created by Ryan on 6/8/2017 AD.
  */

case class RetryOption(times: Int, sleep: Int)

class Retry {
  import scala.util.{Try, Success, Failure}


  def initialTry[T](task: => T)(implicit retryOption: RetryOption) = {
    retry(task, retryOption.times, retryOption.sleep, Failure(new Exception))
  }

  def retry[T](task: => T, times: Int, sleep: Long, trial: Try[T]): Try[T] = {
    if (times <= 0) trial
    else {
      val result = Try(task)
      result match {
        case Success(_) => result
        case t: Failure[T] => {
          Thread.sleep(sleep)
          println(t)
          retry(task, times - 1, sleep, t)
        }
      }
    }
  }
}

object RetryTest extends App {
  implicit val retryOption = RetryOption(times = 3, sleep = 1000)
  val retry = new Retry
  retry.initialTry(3/0)
}
