public class Solution {
    // O(1) space, O(n) time
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(head != null) {
            if(head.val == val) {
                head = head.next;
            } else {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }
        }
        cur.next = head;
        return dummy.next;
    }
}