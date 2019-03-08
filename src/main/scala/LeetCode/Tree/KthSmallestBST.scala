package LeetCode.Tree

/**
  * find kth smallest element in BST
  */
object KthSmallestBST extends App {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    var result = -1
    var acc = 0
    def kthSmallestHelper(node: TreeNode): Unit = {
      if (node == null || acc == k) return
      else {
        kthSmallestHelper(node.left)
        acc = acc + 1
        if (acc == k) result = node.value
        kthSmallestHelper(node.right)
      }
    }
    kthSmallestHelper(root)
    result
  }
}
