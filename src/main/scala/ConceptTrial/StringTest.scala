package ConceptTrial

/**
  * Created by Ryan on 9/3/18.
  */
object StringTest extends App {
  val list1 = List(2, 4, 3, 8)

  for (item <- list1)
  {
    item match {
      case a if 0 to 1 contains a => println("Range A")
      case b if 2 to 3 contains b => println("Range B")
      case c if 4 to 5 contains c => println("Range C")
      case d if 6 to 7 contains d => println("Range D")
      case _ => println("Unknown")
    }
  }
}
