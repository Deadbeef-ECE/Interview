public class Solution {
    // O(1) space OR O(logn) space if recursion stack
    // O(nlogn) time
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode a = head;
        ListNode b = slow.next;
        slow.next = null;
        
        return mergeTwoList(sortList(a), sortList(b));
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            cur.next = l1.val < l2.val ? l1 : l2;
            l1 = cur.next == l1 ? l1.next : l1;
            l2 = cur.next == l2 ? l2.next : l2;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}