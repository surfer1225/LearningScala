package Generic

/**
  * Created by Ryan on 19/10/17.
  */

trait Generic {
  def process[A](msg: A): String
}

