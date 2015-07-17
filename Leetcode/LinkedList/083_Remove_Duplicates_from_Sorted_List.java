public class Solution {
    // O(1) space, O(n) time
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur.next != null){
           if(cur.val != cur.next.val){
               pre.next = cur;
               pre = pre.next;
               cur = cur.next;
           }else{
               cur.next = cur.next.next;
           }
        }
        return dummy.next;
    }
}