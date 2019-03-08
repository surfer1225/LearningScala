package LeetCode.Tree

object MaxDepth {
  def maxDepth(root: TreeNode): Int = {
    def maxDepthHelper(node: TreeNode, lvl: Int): Int = {
      if (node == null) lvl
      else Math.max(maxDepthHelper(node.right, lvl+1), maxDepthHelper(node.left, lvl+1))
    }
    maxDepthHelper(root, 0)
  }
}
