public class Solution {
    // O(1) space, O(n) time
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        int carry = 0;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int digit = (v1 + v2 + carry) % 10;
            carry = (v1 + v2 + carry) / 10;
            ListNode node = new ListNode(digit);
            cur.next = node;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
}