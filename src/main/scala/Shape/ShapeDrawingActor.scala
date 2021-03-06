package Shape

import akka.actor.Actor

object Messages {
  object Exit
  object Finished
  case class Response(message: String)
}

class ShapeDrawingActor extends Actor {
  import Messages._

  override def receive: Receive = {
    case s: Shape =>
      s.draw(str => println(s"ShapesDrawingActor: $str"))
      sender ! Response(s"ShapesDrawingActor: $s drawn")
    case Exit =>
      println(s"ShapesDrawingActor: exiting...")
      sender ! Finished
    case unexpected =>
      val response = Response(s"ERROR: Unknown message: $unexpected")
      println(s"ShapesDrawingActor: $response")
      sender ! response
  }
}
