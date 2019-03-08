package LeetCode

/*
19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:
Could you do this in one pass?
 */
class RemoveNthNodeFromEndList {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    def moveN(node: ListNode, i: Int): ListNode = {
      if (i == 0) node
      else moveN(node.next, i-1)
    }

    def moveBoth(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null) slow
      else moveBoth(slow.next, fast.next)
    }

    val preHead = new ListNode(-1)
    preHead.next = head
    val fastNode = moveN(head, n)

    val temp = moveBoth(preHead, fastNode)
    temp.next = temp.next.next
    preHead.next
  }
}
