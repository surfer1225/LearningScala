package ConceptTrial

class Person(val firstName: String) {
  val address: String = "China"
}

object Person {
  val p = new Person("Ryan")
  def printAddress() = { println(p.address)}
}

object PersonTest extends App {
  Person.printAddress()
}
