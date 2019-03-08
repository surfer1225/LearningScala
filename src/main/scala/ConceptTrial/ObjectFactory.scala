package ConceptTrial

class ObjectFactory(val name: String)

object ObjectFactory {
  def apply(name: String) = new ObjectFactory(name)
}

object ObjectFactoryTest extends App {
  println(ObjectFactory("Ryan").name)
}
