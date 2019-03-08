package HOF

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object FunTest {

  def apply(f: Int => String, v: Int) = f(v)

  def main(args: Array[String]): Unit = {
    var dec = new Decorator("[", "]")
    println(apply(dec.layout, 1))
  }
}

class Decorator(left: String, right: String) {
  def layout[B](x: B) = left + x.toString + right
}

//B is a random type, can be anything