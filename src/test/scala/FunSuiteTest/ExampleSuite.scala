package FunSuiteTest

/**
  * Created by Ryan on 6/6/2017 AD.
  */
import org.scalatest.FunSuite

import scala.collection.mutable
import scala.collection.mutable.Stack

class ExampleSuite extends FunSuite{
  test("pop is invoked on a non-empty stack") {

    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
    val result = stack.pop()
    assert(result === 2)
    assert(stack.size === oldSize - 1)
  }

  test("pop is invoked on an empty stack") {

    val emptyStack = new mutable.Stack[Int]
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    assert(emptyStack.isEmpty)
  }
}
