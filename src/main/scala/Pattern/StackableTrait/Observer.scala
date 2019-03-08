package Pattern.StackableTrait

trait Observer[-State] {
  /**
    * trait for clients willing to be notified of state changes
    * @param state: to record state changes
    */
  def receiveUpdate(state: State): Unit
}
