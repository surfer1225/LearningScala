package LeetCode

/*
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
package object Tree {
  def isSymmetric(root: TreeNode): Boolean = {
    if (root==null) true
    else isSame(root.left, root.right)
  }

  def isSame(m: TreeNode, n: TreeNode): Boolean = {
    if (m==null&&n==null) true
    else if (m==null||n==null) false
    else if (m.value != n.value) false
    else isSame(m.left, n.right) && isSame(m.right, n.left)
  }
}
