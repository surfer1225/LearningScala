package TraitExample

/**
  * Created by Ryan on 6/5/2017 AD.
  */
trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet
