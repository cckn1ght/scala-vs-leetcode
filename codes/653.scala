/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.Set
object Solution {
  def findTarget(root: TreeNode, k: Int): Boolean = {
    var cache = Set[Int]()
    helper(root, cache, k)
  }
  def helper(t: TreeNode, cache: Set[Int], k: Int): Boolean = {
    if (t == null) return false
    if (cache.contains(t.value)) return true
    cache.add(k - t.value)
    helper(t.left, cache, k) || helper(t.right, cache, k)
  }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.ArrayBuffer
object Solution {
  def findTarget(root: TreeNode, k: Int): Boolean = {
    var li = ArrayBuffer[Int]()
    inorder(root, li)
    var l = 0
    var r = li.length - 1
    while(l < r) {
      var total = li(l) + li(r)
      if (total < k) {
        l += 1
      } else if (total > k) {
        r -= 1
      } else {
        return true
      }
    }
    false
  }
  def inorder(t: TreeNode, li: ArrayBuffer[Int]): Unit = {
    if (t == null) return
    inorder(t.left, li)
    li += t.value
    inorder(t.right, li)
  }
}