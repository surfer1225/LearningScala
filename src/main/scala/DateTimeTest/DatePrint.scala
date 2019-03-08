package DateTimeTest

import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.util.Date

object DatePrint extends App {
  println(new Date)
  println(ZonedDateTime.now())
  val s = new SimpleDateFormat("YYYY-mm-dd'T'hh:mm:ssZ")
  println(s.format(new Date))
}
