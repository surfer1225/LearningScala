package Refactor

/**
  * Created by Ryan on 6/7/2017 AD.
  */
object NoDot extends App {
  def isEven(n: Int) = (n % 2) == 0

  /*
  List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i))
  List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))
  List(1, 2, 3, 4).filter(isEven).foreach(println)
  */
  List(1, 2, 3, 4) filter isEven foreach println
}
