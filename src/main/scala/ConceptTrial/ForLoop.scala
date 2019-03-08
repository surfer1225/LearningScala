package ConceptTrial

/**
  * Created by Ryan on 6/9/2017 AD.
  */
object ForLoop extends App {
  val l = List(1, 2, 3, 4)//logic can stay in for blocks
  val newList = for {
    node <- l
    if node%2 == 0
    newNode = node + 1
  } yield newNode
  println(newList)

  for {
    node <- l
  //  println(node)
  } println("outside: " + node)
}
