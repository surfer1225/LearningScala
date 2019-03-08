package Test

/**
  * Created by Ryan on 6/8/2017 AD.
  */
class SquareList {
  def squareMapList(xs: List[Int]): List[Int] = xs.map(x => x * x)

  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => xs
    case y :: ys => y * y :: squareList(ys)
  }
}

/*
This is an equivalent of pattern matching for lists
wherein your x matches with head of the list while ys matches with the tail.
In pattern maching allows you to de-structure the input to match a given pattern,
in this case a list with y as head and ys as tail
 */