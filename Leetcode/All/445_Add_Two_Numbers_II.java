public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        ListNode reversel1 = reverseList(l1);
        ListNode reversel2 = reverseList(l2);
        ListNode head = sumUp(reversel1, reversel2);
        ListNode reverseHead = reverseList(head);
        return reverseHead;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = null;
        while(next != null){
            dummy.next = next;
            ListNode record = next;
            next = next.next;
            dummy.next.next = cur;
            cur = record;
        }
        return dummy.next;
    }
    
    public ListNode sumUp(ListNode l1, ListNode l2){
        /* Actually, no check needed here */
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            ListNode curNode = new ListNode(digit);
            cur.next = curNode;
            cur = curNode;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
}