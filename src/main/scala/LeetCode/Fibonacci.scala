package LeetCode

object Fibonacci extends App {
  // this is not tail rec
  def fibonacci(i: Int): Long = {
    if (i<=1) 1L
    else fibonacci(i-1) + fibonacci(i-2)
  }

  println(fibonacci(4))
}
