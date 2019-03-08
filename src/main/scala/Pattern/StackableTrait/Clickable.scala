package Pattern.StackableTrait

trait Clickable {
  def click(): Unit = updateUI()

  protected def updateUI(): Unit
}
