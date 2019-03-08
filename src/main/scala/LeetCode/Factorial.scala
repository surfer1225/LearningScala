package LeetCode

import scala.annotation.tailrec

object Factorial extends App {
  def factorial(i: Int): Long = {
    @tailrec
    def factHelper(i: Int, accumulator: Int): Long = {
      if (i<=1) accumulator
      else factHelper(i-1, accumulator*i)
    }
    factHelper(i, 1)
  }

  println(factorial(5))
}
