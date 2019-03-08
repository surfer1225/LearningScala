package Test

import org.scalatest.FunSuite

/**
  * Created by Ryan on 6/7/2017 AD.
  */
class StringTest extends FunSuite {
  test("test longest word in string") {
    val testStr = "Go! Golden State Warrior"
    val stringTasks = new StringTasks
    assert(stringTasks.longestWord(testStr) === "Warrior")
  }

  test("test most common word in string") {
    val testStr = "Go! Golden State Warrior! Go Go Go"
    val stringTasks = new StringTasks
    assert(stringTasks.mostCommonWord(testStr) === "Go")
  }

  test("test most common char in string") {
    val testStr = "Go! Golden State Warrior! Go Go Go"
    val stringTasks = new StringTasks
    assert(stringTasks.mostCommonChar(testStr) === 'o')
  }

  test("test converting string list to char list") {
    val l = List("Agoda", "rocks!")
    val task = new StringTasks
    val charL = List(List('A', 'g', 'o', 'd', 'a'), List('r', 'o', 'c', 'k', 's', '!'))
    assert(task.strlistToCharList(l) === charL)
  }
}
