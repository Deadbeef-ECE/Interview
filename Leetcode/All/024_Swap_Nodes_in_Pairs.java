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
    // Split + Combine， 灵感来源于copy linked list with random pointer
    // O(n) time, O(1) space
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while(even != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd == null ? null : odd.next;
            even = even.next;
        }
        odd = head;
        even = evenHead;
        while(even != null){
            ListNode evenTmp = even.next;
            ListNode oddTmp = odd.next;
            even.next = odd;
            odd.next = evenTmp == null ? odd.next : evenTmp;
            odd = oddTmp;
            even = evenTmp;
        }
        return evenHead;
    }
}