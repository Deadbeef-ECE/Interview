public class Solution {
    // O(1) space, O(n) time
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)
            return head;
            
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 1; i < m; i++){
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode record = cur;
        
        prev.next = null;
        while(m <= n){
            ListNode temp = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = temp;
            m++;
        }
        record.next = cur;
        return dummy.next;
    }
}