package DateTimeTest

import scala.concurrent.duration._

/**
  * Created by Ryan on 29/9/17.
  */
object DurationTest extends App {

  val d1 = 1200.milliseconds
  val d2 = 1.second

  val now = System.nanoTime()
  val andthen = System.currentTimeMillis()

  println((1,2) == (1,3))

  println(now)
  println(andthen)

  println(d1 > d2)
}
