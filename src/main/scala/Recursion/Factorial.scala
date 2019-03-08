package Recursion

/**
  * Created by Ryan on 6/7/2017 AD.
  */
object Factorial {

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def main(args: Array[String]): Unit = {
    println(factorial(4))
  }
}
