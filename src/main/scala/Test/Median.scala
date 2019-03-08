package Test

/**
  * Created by Ryan on 6/9/2017 AD.
  */
/*
Q. Add a method "median" to a Seq of integers so that
s.median is the median of s for s of type Seq[Int]
How can you add the same method for a sequence of doubles with minimal code duplication?
 */
class Median[A](var numbers: Seq[A]) {
  // ignore non-number cases
  numbers = numbers.sortWith(_.toString.toDouble < _.toString.toDouble)
  def median = {
    val middle = numbers.length / 2
    if (numbers.length%2 == 1) {
      println()
      numbers(middle)
    }
    else {
      (numbers(middle - 1).toString.toDouble + numbers(middle).toString.toDouble) / 2
    }
  }
}

object ToMedian extends App {

  implicit def intsToMedian(numbers: Seq[Int]) = new Median[Int](numbers)
  implicit def doublesToMedian(numbers: Seq[Double]) = new Median[Double](numbers)

  println(Seq(1, 3, 8, 4, 7).median)
  println(Seq(1, 3.2, 4.1, 7).median)
}
