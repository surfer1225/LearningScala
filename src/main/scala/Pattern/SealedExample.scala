package Pattern

/**
  * Created by Ryan on 6/5/2017 AD.
  */
sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture

/*
def findPlaceToSit(piece: Furniture): String = piece match {
  case a: Couch => "Lie on the couch"
  case b: Chair => "Sit on the chair"
}
*/
/*
Traits and classes can be marked sealed which means all subtypes must be declared in the same file.
The assures that all subtypes are known.
*/

