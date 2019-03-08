package LeetCode.ArrayQuestions

/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a contiguous subarray of which the sum ≥ s.
If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
object MinSizeSubArrSum extends App {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    val l = nums.length
    var min = Integer.MAX_VALUE
    var sum = 0
    var start = 0
    for (i <- 0 until l) {
      sum += nums(i)
      while (sum >= s) {
        min = Math.min(min, i - start + 1)
        sum -= nums(start)
        start += 1
      }
    }
    if (min == Integer.MAX_VALUE) 0 else min
  }

  println(minSubArrayLen(7, Array(2,3,1,2,4,3)))
  println(minSubArrayLen(4, Array(1,4,4)))
}
