public class Solution {
    // Iteration（最简洁版本）: 
    // O(1) space, O(n) time
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = tmp;
        }
        return dummy.next;
    }

    // Recursion:
    // O(1) space OR O(n) space if consider recursion stack
    // O(n) time
    public ListNode reverseList(ListNode node) {
        if(node.next == null)   return node;
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}