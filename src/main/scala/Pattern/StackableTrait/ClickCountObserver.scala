package Pattern.StackableTrait

class ClickCountObserver extends Observer[Clickable] {
  var count = 0

  override def receiveUpdate(state: Clickable): Unit = {
    count += 1
  }
}

object ClickCountObserverTest extends App {
  val button = new Button("Click!") with ObservableClicks

  val b1 = new ClickCountObserver
  val b2 = new ClickCountObserver

  (1 to 5) foreach (_ => button.click())
  assert(b1.count == 5)
  assert(b2.count == 5)
}
