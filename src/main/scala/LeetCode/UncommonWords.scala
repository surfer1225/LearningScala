package LeetCode

/*
884. Uncommon Words from Two Sentences

We are given two sentences A and B.  (A sentence is a string of space separated words.
Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences,
and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]
 */
object UncommonWords extends App {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    val setA = A.split(" ").toSet
    val setB = B.split(" ").toSet

    setA.diff(setB) union setB.diff(setA) toArray
  }

  uncommonFromSentences("apple apple","banana")
}
