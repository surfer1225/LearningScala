package ConceptTrial

/**
  * Created by Ryan on 6/9/2017 AD.
  */
object PatternTrial extends App {
  for {
    x <- Seq(1, 2, 2.7, "One", 'four)
  } {
    val str = x match {
      case 1         => "int 1"
      case _: Int    => "other int: " + x
      case _: Double => "a double: " + x
      case "One"     => "string one"
      case _: String => "other string: " + x
      case _         => "unexpected"
    }

    println(str)
  }

  def checkY(y: Int) = {
    for {
      x <- Seq(99, 100)
    } {
      val str = x match {
        case `y` => "found y"
        case i: Int => "int: " + i
      }
      println(str)
    }
  }

  checkY(100)
}
