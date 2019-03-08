package Bound

/**
  * Created by Ryan on 6/6/2017 AD.
  */
abstract class Animal {
  def name: String
}
abstract class Pet extends Animal {}
class Cat extends Pet {
  override def name: String = "Cat"
}
class Dog extends Pet {
  override def name: String = "Dog"
}
class Lion extends Animal {
  override def name: String = "Lion"
}
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}

object BoundTest {
  def main(args: Array[String]): Unit = {
    val dogContainer = new PetContainer[Dog](new Dog)
    val catContainer = new PetContainer[Cat](new Cat)
    //  val lionContainer = new PetContainer[Lion](new Lion)
    //                         ^this would not compile

    println(dogContainer.pet.name)
  }
}
