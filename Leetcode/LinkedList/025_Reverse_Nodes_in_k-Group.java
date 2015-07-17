public class Solution {
    // O(1) space, O(n) time
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        
        int cnt = 0;
        while(cur != null){
            cnt++;
            if(cnt % k == 0){
                pre = reverse(pre, cur.next);
                cur = pre.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode start, ListNode end){
        ListNode cur = start.next;
        ListNode next = cur.next;
        while(next != end){
            cur.next = next.next;
            next.next = start.next;
            start.next = next;
            next = cur.next;
        }
        return cur;
    }
}