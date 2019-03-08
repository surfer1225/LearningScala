package ClassExample

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object PointTest {
  def main(args: Array[String]): Unit = {
    val point1 = new Point(2, 3)
    println("x coordinate: " + point1.x)  // 2
    println(point1)  // prints (x, y)

    val point2 = new PrivatePoint
    point2.x = 99
    point2.y = 101 // prints the warning
  }
}
