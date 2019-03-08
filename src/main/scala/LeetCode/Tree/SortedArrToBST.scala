package LeetCode.Tree

/*
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
object SortedArrToBST {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    def arrToBST(l: Int, r: Int): TreeNode = {
      if (l>r) null
      else {
        val mid = (r-l)/2+l
        val root = new TreeNode(nums(mid))
        root.left = arrToBST(l, mid-1)
        root.right = arrToBST(mid+1,r)
        root
      }
    }
    arrToBST(0, nums.length-1)
  }
}
