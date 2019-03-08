package ClassExample

/**
  * Created by Ryan on 6/5/2017 AD.
  */
class PrivatePoint {
  private var _x = 0
  private var _y = 0
  private val bound = 100
  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }
  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }
  private def printWarning = println("WARNING: Out of bounds")
}

/*
In this version of the Point class, the data is stored in private variables _x and _y.
There are methods def x and def y for accessing the private data.
def x_= and def y_= are for validating and setting the value of _x and _y.
Notice the special syntax for the setters:
the method has _= appended to the identifier of the getter and the parameters come after.
 */

/*
Primary constructor parameters with val and var are public.
However, because vals are immutable, you can’t write the following.

class Point(val x: Int, val y: Int)
val point = new Point(1, 2)
point.x = 3  // <-- does not compile

Parameters without val or var are private values, visible only within the class.
class Point(x: Int, y: Int)
val point = new Point(1, 2)
point.x  // <-- does not compile
 */
