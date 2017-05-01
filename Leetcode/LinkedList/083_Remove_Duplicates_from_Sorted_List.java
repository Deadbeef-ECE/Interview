public class Solution {
    // O(1) space, O(n) time
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while(next != null){
            if(next.val == cur.val){
                next = next.next;
            }else{
                cur.next = next;
                cur = cur.next;
                next = next.next;
            }
        }
        cur.next = next;
        return dummy.next;
    }
}