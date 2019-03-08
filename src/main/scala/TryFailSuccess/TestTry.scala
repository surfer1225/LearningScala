package TryFailSuccess

import java.io.{IOException, PrintWriter, StringWriter}

/**
  * Created by Ryan on 6/8/2017 AD.
  */
object TestTry extends App {
  import scala.util.{Try, Success, Failure}

  badAdder(2) match {
    case Success(i) => println(s"success, i = $i")
    case Failure(t) =>
      println(s"CLASS = ${t.getClass}")

      // this works, but it's not too useful/readable
      //println(t.getStackTrace.mkString("\n"))

      // this works much better
      val sw = new StringWriter
      t.printStackTrace(new PrintWriter(sw))
      println(sw.toString)
  }

  /**
    * This method returns a `Success[Int]` if everything goes well,
    * otherwise it throws an exception wrapped in a `Failure`.
    */
  def badAdder(a: Int): Try[Int] = {
    Try({
      val b = a + 1
      if (b == 3) b else {
        val ioe = new IOException("Boom!")
        throw new AlsException("Bummer!", ioe)
      }
    })
  }

  class AlsException(s: String, e: Exception) extends Exception(s: String, e: Exception)
}
