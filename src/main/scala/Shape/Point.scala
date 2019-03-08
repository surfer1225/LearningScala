package Shape

case class Point(x: Double = 0.0, y: Double = 0.0) {
  def shift(deltax: Double = 0.0, deltay: Double = 0.0) = copy(x + deltax, y + deltay)
}

abstract class Shape() {
  def draw(f: String => Unit): Unit = f(s"draw: ${this.toString}")
}

case class Circle(center: Point, radius: Double) extends Shape

case class Rectangle(lowerLeft: Point, height: Double, width: Double) extends Shape

case class Triangle(p1: Point, p2: Point, p3: Point)
