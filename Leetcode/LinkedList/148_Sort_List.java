public class Solution {
    // O(1) space OR O(logn) space if recursion stack
    // O(nlogn) time
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        ListNode firstHalf = head;
        ListNode secondHalf = null;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // cut the list
        secondHalf = slow.next;
        slow.next = null;
        
        // sort
        ListNode leftHead = null, rightHead = null;
        if(firstHalf != secondHalf){
            leftHead = sortList(firstHalf);
            rightHead = sortList(secondHalf);
        }
        return mergeTwoList(leftHead, rightHead);
    }
    
    private ListNode mergeTwoList(ListNode l, ListNode r){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l != null && r != null){
            cur.next = l.val < r.val ? l : r;
            l = cur.next == l ? l.next : l;
            r = cur.next == r ? r.next : r;
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return dummy.next;
    }
}