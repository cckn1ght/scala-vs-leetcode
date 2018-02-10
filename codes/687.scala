/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def longestUnivaluePath(root: TreeNode): Int = {
    if (root == null) {
      0
    } else {
      // 假设 findLength 会找到以某个节点为分叉节点的最长相同值路径
      val nodeLen = findLength(root) // 以当前节点为分叉节点的最长相同值路径
      val leftLen = longestUnivaluePath(root.left) // 左子树的最长路径
      val rightLen = longestUnivaluePath(root.right) // 右子树的最长路径
      // 返回上面三个值中最大的那个
      (nodeLen :: leftLen :: rightLen :: Nil) reduce (_ max _) // 构造一个 list 并返回最大值
    }
  }
  def findLength(node: TreeNode): Int = {
    findChildLength(node.left, node.value) + findChildLength(node.right, node.value)
  }
  def findChildLength(child: TreeNode, rootValue: Int): Int = {
    if (child == null || child.value != rootValue) {
      0
    } else {
      val left = findChildLength(child.left, rootValue)
      val right = findChildLength(child.right, rootValue)
      1 + (left max right)
    }
  }
}