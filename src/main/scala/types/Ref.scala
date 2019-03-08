package types

/**
  * Created by yao on 4/6/17.
  */
object Ref {
  def main(args: Array[String]) {
    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    list.foreach(element => println(element))
  }
}
