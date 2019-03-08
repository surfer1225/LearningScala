package ConceptTrial

object LongString extends App {
  def hello(name: String) =
    s"""
       |Welcome!
       |Hello, $name!
       * (Gratuitous Star!)
       |  We're glad you are here
     """.stripMargin

  println(hello("Yao"))
}
