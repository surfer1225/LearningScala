package LeetCode

/*
33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
object SearchRotatedSortedArr extends App {
  def search(nums: Array[Int], target: Int): Int = {
    def bSearch(l: Int, r: Int): Int = {
      if (r<l) -1
      else {
        val mid = (r-l)/2+l
        if (nums(mid)==target) mid
        else {
          if ((nums(mid)>nums(l)&&target<nums(mid)&&target>=nums(l)) ||
            (nums(mid)<nums(l)&&(target>=nums(l)||target<nums(mid))))
            bSearch(l,mid)
          else
            bSearch(mid+1,r)
        }
      }
    }
    bSearch(0, nums.length-1)
  }

  println(search(Array(4,5,6,7,0,1,2), 0))
  println(search(Array(4,5,6,7,0,1,2), 3))
  println(search(Array(1,3), 1))
  println(search(Array(1,3,5), 5))
}
