public class Solution {
    // O(1) space, O(n) time
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)    return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode prev = dummy;
        while(cur != null){
            if(cur.val == val){
                cur = cur.next;
            }else{
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
            }
        }
        prev.next = cur;
        return dummy.next;
    }
}