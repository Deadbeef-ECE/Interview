public class Solution {
    // O(1) space, O(n) time
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode small = smallHead, big = bigHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                small.next = cur;
                small = small.next;
            }else{
                big.next = cur;
                big = big.next;
            }
            cur = cur.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }
}