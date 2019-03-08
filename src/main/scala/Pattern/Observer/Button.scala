package Pattern.Observer

class Button(val label: String) extends Widget {
  def click(): Unit = updateUI()

  /**
    * logic to change UI
    */
  def updateUI(): Unit = { }
}
