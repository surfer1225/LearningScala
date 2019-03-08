package ListOps

/**
  * Created by Ryan on 6/5/2017 AD.
  */
case class User (val name: String, val age: Int)

object UserTest {

  def foo(n: Int, v: Int) =
    for (i <- 0 until n;
         j <- i until n if i + j == v)
      yield (i, j)

  def main(args: Array[String]): Unit = {
    val userBase = List(new User("Travis", 28),
      new User("Kelly", 33),
      new User("Jennifer", 44),
      new User("Dennis", 23))
    val twentySomethings = for (user <- userBase if (user.age >=20 && user.age < 30))
      yield user.name  // i.e. add this to a list
    twentySomethings.foreach(name => println(name))  // prints Travis Dennis

    foo(10, 10) foreach {
      case (i, j) =>
        print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
    }
  }
}

//comprehensions with the form for (enumerators) yield e,
// where enumerators refers to a semicolon-separated list of enumerators.
/*
The for loop used with a yield statement actually creates a List.
Because we said yield user.name, it’s a List[String].
user <- userBase is our generator and if (user.age >=20 && user.age < 30)
is a guard that filters out users who are in their 20s.
 */