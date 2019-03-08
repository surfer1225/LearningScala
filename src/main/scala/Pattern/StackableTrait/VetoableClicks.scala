package Pattern.StackableTrait

trait VetoableClicks extends Clickable {
  val maxAllowed = 1
  private var count = 0

  abstract override def click(): Unit = {
    if (count < maxAllowed) {
      count += 1
      super.click()
    }
  }
}

object VetoTest extends App {
  val button = new Button("Veto Click") with ObservableClicks with VetoableClicks {
    override val maxAllowed: Int = 2
  }

  val b1 = new ClickCountObserver
  val b2 = new ClickCountObserver

  button addObserver b1
  button addObserver b2

  (1 to 5) foreach (_ => button.click())

  assert(b1.count == 2)
  assert(b2.count == 2)

  println("Success!")
}
