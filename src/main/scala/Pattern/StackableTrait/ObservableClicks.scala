package Pattern.StackableTrait

trait ObservableClicks extends Clickable with Subject[Clickable] {
  /**
    * click method not concrete yet
    */
  abstract override def click(): Unit = {
    super.click()
    notifyObservers(this)
  }
}
