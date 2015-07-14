public class Solution {
    // Iteration:
    // O(1) space, O(n) time
    public ListNode reverseList(ListNode node) {
        if(node == null || node.next == null)
            return node;
        ListNode dummy = new ListNode(-1);
        ListNode cur = node;
        ListNode tail = dummy.next;
        ListNode front = node.next;
        while(cur != null){
            dummy.next = cur;
            cur.next = tail;
            tail = cur;
            cur = front;
            front = front == null ? null : front.next;
        }   
        return dummy.next;
    }

    // Recursion:
    // O(1) space OR O(n) space if consider recursion stack
    // O(n) time
    public ListNode reverseList(ListNode node) {
        if(node.next == null)   return node;
        ListNode newHead = reverseLinkedListRec(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}