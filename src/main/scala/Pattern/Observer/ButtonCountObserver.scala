package Pattern.Observer

class ButtonCountObserver(val name: String) extends Observer[Button] {
  var count = 0

  override def receiveUpdate(state: Button): Unit = {
    println(s"$name says ${state.label}")
    count += 1
  }
}

object ButtonTest extends App {
  val button = new ObservableButton("Click Me!")
  val bco1 = new ButtonCountObserver("b1")
  val bco2 = new ButtonCountObserver("b2")

  button addObserver bco1
  button addObserver bco2

  (1 to 5) foreach (_ => button.click())

  assert(bco1.count == 5)
  assert(bco2.count == 5)
}
