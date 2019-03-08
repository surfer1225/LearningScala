package LeetCode

/**
  * Created by Ryan on 13/1/18.
  */

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */

import scala.collection.mutable.Stack
object RevertVowels extends App {
  println(reverseVowels("ai"))
  def reverseVowels(s: String): String = {
    val set = Set('a', 'e', 'i', 'o', 'u')
    val stack = Stack[Char]()
    s.foreach { c =>
      if (set.contains(c.toLower)) stack.push(c)
    }
    s.map { c =>
      if (set.contains(c)) stack.pop
      else c
    }
  }
}
