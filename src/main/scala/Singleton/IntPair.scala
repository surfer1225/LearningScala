package Singleton

/**
  * Created by Ryan on 6/5/2017 AD.
  */
class IntPair(val x: Int, val y: Int)

object IntPair {
  import math.Ordering
  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

/*
Most singleton objects do not stand alone, but instead are associated with a class of the same name.
The “singleton object of the same name” of a case class, mentioned above, is an example of this.
When this happens, the singleton object is called the companion object of the class,
and the class is called the companion class of the object.
 */