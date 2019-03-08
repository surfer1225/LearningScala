package ClassExample

/**
  * Created by Ryan on 6/5/2017 AD.
  */
//method signature with Unit return value
class Point (var x: Int, var y: Int) {
  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }
  override def toString: String =
    s"($x, $y)"
}

/*
class Point(var x: Int = 0, var y: Int = 0)
val origin = new Point  // x and y are both set to 0
val point1 = new Point(1)
println(point1.x)  // prints 1
 */