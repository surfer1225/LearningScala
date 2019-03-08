package Default

/**
  * Created by Ryan on 6/6/2017 AD.
  */
object DefaultTest extends App {
  def log(msg: String, lvl: String = "INFO") = println(s"$lvl: $msg")
  log("System starting")
  log("User not found", "WARNING")
}
//parameter can have default value, optional to supply it