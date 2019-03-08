package Test

import java.time.Instant

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Ryan on 6/7/2017 AD.
  */
class Timer {
  def time[T](task: => T): T = {
    println("test lazy in Timer")
    val startTime = System.nanoTime()
    val result = task
    val endTime = System.nanoTime()
    println("Elapsed time: " + (endTime - startTime) + "ns")
    result
  }

  def timeFuture[T](task: => T): Future[T] = {
    Future {
      time(task)
    }
  }

  def measureF[B](f: => Future[B]): Future[B] = {
    val start = Instant.now
    val result = f
    result.onComplete {
      case Success(result) =>
        val elapsed = java.time.Duration.between(start, Instant.now).toMillis
        println("Elapsed future measuring time: " + elapsed)
      case Failure(_) =>
        val elapsed = java.time.Duration.between(start, Instant.now).toMillis
        println("Elapsed future measuring time: " + elapsed)
    }
    result
  }
}
// understand the difference bet/w passing by name/function
// concept of lazy loading
object TimerWrapper extends App {
  val timer = new Timer
  def testInt(a: Int): Int = {
    println("test lazy")
    Thread.sleep(1000)
    a+3
  }
  //println(timer.time(testInt(5)))
  println(timer.measureF(timer.timeFuture(timer.time(testInt(5)))))
  Thread.sleep(10000)
}
