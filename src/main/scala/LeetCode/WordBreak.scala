package LeetCode

import util.control.Breaks._
/*
139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
object WordBreak extends App {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val wordSet = wordDict.toSet
    val l = s.length
    val res = new Array[Boolean](l+1)
    //DP to store true/false of substring of the word
    res(0) = true

    (1 to l) foreach { i=>
      breakable {
        (0 until i) foreach { j=>
          if (res(j) && wordSet.contains(s.substring(j, i))) {
            res(i) = true
            break
          }
        }
      }
    }
    res(l)
  }
  println(wordBreak("applepenapple", List("apple", "pen")))
  println(wordBreak("cars", List("car", "ca", "rs")))
  println(wordBreak("cbca", List("bc", "ca")))
  println(wordBreak("ccaccc", List("cc", "ac")))
  println(wordBreak("ccaccc", List("ac", "cc")))
}
