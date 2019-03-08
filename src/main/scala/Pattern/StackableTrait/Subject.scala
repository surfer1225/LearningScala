package Pattern.StackableTrait

trait Subject[State] {

  /**
    * list of observers to notify, mutable, not thread-safe
    */
  private var observers: List[Observer[State]] = Nil

  /**
    * method to add observers
    * @param observer: observer instance
    */
  def addObserver(observer: Observer[State]): Unit =
    observers ::= observer

  /**
    * method to notify observers of state changes
    * @param state: new state
    */
  def notifyObservers(state: State): Unit =
    observers foreach (_.receiveUpdate(state))
}
