package Pattern.StackableTrait

class Button(val label: String) extends Widget with Clickable {
  /**
    * real logic to change UI
    */
  override protected def updateUI(): Unit = {}
}
