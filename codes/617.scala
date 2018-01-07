/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if (t1 == null) return t2 // base case
    if (t2 == null) return t1 // another base case
    val root = new TreeNode(t1.value + t2.value) // 从根节点开始
    root.left = mergeTrees(t1.left, t2.left) // 分别看根节点的左子树
    root.right = mergeTrees(t1.right, t2.right) // 以及右子树
    root
  }
}