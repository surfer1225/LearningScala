package TraitExample

/**
  * Created by Ryan on 6/5/2017 AD.
  */

/*
Traits are used to share interfaces and fields between classes.
They are similar to Java 8’s interfaces.
Classes and objects can extend traits but traits cannot be instantiated and
therefore have no parameters.
 */

object IteratorTest {
  def main(args: Array[String]): Unit = {
    val iterator = new IntIterator(10)
    println(iterator.next())  // prints 0
    println(iterator.next())  // prints 1

    val dog = new Dog("Bark")
    val cat = new Cat("Meow")

    import scala.collection.mutable.ArrayBuffer
    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name))
  }
}
/*
The trait Pet has an abstract field name which gets implemented by Cat and Dog in their constructors.
On the last line, we call pet.name which must be implemented in any subtype of the trait Pet.
 */