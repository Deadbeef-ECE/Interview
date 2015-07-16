public class Solution {
    // O(1) space, O(n^2) time
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        
        while(cur != null){
            ListNode next = cur.next;
            pre = dummy;
            while(pre.next != null && pre.next.val <= cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}