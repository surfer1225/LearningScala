package CurryAndNestedFunction

/**
  * Created by Ryan on 6/5/2017 AD.
  */
object Example {
  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }

  //"filter and modN" are for currying
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)
  def modN(n: Int)(x: Int) = ((x % n) == 0)

  def main(args: Array[String]): Unit = {
    println(factorial(4))// Nested Function
    val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
    println(filter(nums, modN(2)))
    println(filter(nums, modN(3)))
  }
}
