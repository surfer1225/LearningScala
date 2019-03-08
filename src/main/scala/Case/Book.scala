package Case

/**
  * Created by Ryan on 6/5/2017 AD.
  */
case class Book(isbn: String, author: String, year: Int)

object BookCompare extends App {
  val a = new Book("1234", "Yao", 2010)
  val b = new Book("12345", "Yao", 2010)

  println(a.equals(b))
  println(a == b)
  println(None.size)
}
/*
case class Message(sender: String, recipient: String, body: String)
val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
println(message1.sender)  // prints guillaume@quebec.ca
message1.sender = "travis@washington.us"  // this line does not compile


You can’t reassign message1.sender because it is a val (i.e. immutable).
It is possible to use vars in case classes but this is discouraged.
*/

/*
case class Message(sender: String, recipient: String, body: String)
val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
val messagesAreTheSame = message2 == message3  // true
 */