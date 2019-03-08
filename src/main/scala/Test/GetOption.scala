package Test

/**
  * Created by Ryan on 6/8/2017 AD.
  */

//Write a function that gets an optional x,y and z and returns the first that is not None
class GetOption {
  def getNotNone[A](args: A*): A = {
    args.filter(_ != None).head
  }

  def firstNonEmpty[A](a: Option[A], b: Option[A], c: Option[A]) =
    a.getOrElse(b.getOrElse(c.getOrElse(None)))
}

