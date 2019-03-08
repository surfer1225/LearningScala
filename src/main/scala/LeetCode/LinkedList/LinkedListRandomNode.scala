package LeetCode.LinkedList

/*
382. Linked List Random Node

Given a singly linked list, return a random node's value from the linked list.
Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */
class Solution(_head: ListNode) {

  /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */


  /** Returns a random node's value. */
  def getRandom(): Int = {
    def getLength(node: ListNode, acc: Int): Int = {
      if (node == null) acc
      else getLength(node.next, acc+1)
    }
    val l = getLength(_head, 0)
    val r = Math.random() * l
    def getNum(node: ListNode, acc: Int): Int = {
      if (acc == r) node.x
      else getNum(node.next, acc+1)
    }
    getNum(_head, 0)
  }

}

/**
  * Your Solution object will be instantiated and called as such:
  * var obj = new Solution(head)
  * var param_1 = obj.getRandom()
  */
