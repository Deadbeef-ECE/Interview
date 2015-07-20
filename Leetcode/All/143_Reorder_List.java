public class Solution {
    // O(1) space, O(n) time
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null || fast.next == null)   break;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode hd1 = head;
        ListNode hd2 = slow.next;
        slow.next = null;
        // reverse the second list
        ListNode cur = hd2;
        ListNode next = cur.next;
        cur.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        hd2 = cur;
        // reorder
        ListNode p = hd1;
        ListNode q = hd2;
        while(q != null){
            ListNode tmp1 = p.next;
            ListNode tmp2 = q.next;
            p.next = q;
            q.next = tmp1;
            p = tmp1;
            q = tmp2;
        }
    }
}