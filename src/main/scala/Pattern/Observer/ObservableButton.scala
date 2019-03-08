package Pattern.Observer

class ObservableButton(name: String) extends Button(name) with Subject[Button] {
  override def click(): Unit = {
    super.click()
    notifyObservers(this)
  }
}
