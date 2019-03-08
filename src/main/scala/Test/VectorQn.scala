package Test

/**
  * Created by Ryan on 6/9/2017 AD.
  */

class VectorQn(numbers: Vector[Int]) {

  lazy val x = Utils.squareMapList(numbers)
  lazy val y = x.foldLeft(0)(_ + _)
  lazy val z = Math.sqrt(y)
}

object Utils {
  def squareMapList(xs: Vector[Int]): Vector[Int] = xs.map(x => x * x)
}

object VectorQnTest extends App {
  var vector = new VectorQn(Vector(1, 3, 5, 8))
  println(vector.x)
  println(vector.y)
  println(vector.z)
}
