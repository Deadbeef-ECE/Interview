public class Solution {
	// Solution 1: reverse and add
    public ListNode plusOne(ListNode head) {
        if(head == null)    return head;
        ListNode rhead = reverseList(head);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 1;
        while(rhead != null){
            int digit = (carry + rhead.val) % 10;
            carry = (carry + rhead.val) / 10;
            ListNode tmp = new ListNode(digit);
            cur.next = tmp;
            cur = cur.next;
            rhead = rhead.next;
        }
        if(carry == 1)  cur.next = new ListNode(1);
        ListNode newHead = reverseList(dummy.next);
        return newHead;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Solution 2: recursion
    
}