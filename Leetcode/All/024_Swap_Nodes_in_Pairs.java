public class Solution {
    // Three pointer:
    // O(1) space, O(n) time
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        
        while(next != null){
            ListNode temp = next.next;
            prev.next = next;
            next.next = cur;
            cur.next = temp;
            prev = cur;
            cur = temp;
            next = cur == null ? null : cur.next;
        }
        return dummy.next;
    }
}