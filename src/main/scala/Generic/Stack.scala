package Generic

/**
  * Created by Ryan on 6/5/2017 AD.
  */
class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements}
  def peek(): A = {elements.head}
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }

}

//A is the generic
