package Test

/**
  * Created by Ryan on 6/8/2017 AD.
  */
class MapListToList {
  def convertList(l1: List[Int], m: Map[Int, Int]): List[Int] = {
    for {
      x <- l1
      if m.contains(x)
    } yield m.get(x).get * x
  }
}

/*
Given a list:List[Int] and map:Map[Int, Double], multiply all the numbers in the list
with their corresponding value in the map,
and drop if don't exists
for example: list = [1,2,3,4], map = {1 -> 3, 3-> 5} ==> res = [3.0, 15.0]
 */