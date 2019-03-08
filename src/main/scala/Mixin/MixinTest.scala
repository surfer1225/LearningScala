package Mixin

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object MixinTest {
  def main(args: Array[String]): Unit = {
    class Iter extends StringIterator("Hello World") with RichIterator
    val iter = new Iter

    iter foreach toUpper
  }

  def toUpper(c: Char): Unit = {
    val a = c.toString.toUpperCase() charAt 0
    println(a)
  }
}
