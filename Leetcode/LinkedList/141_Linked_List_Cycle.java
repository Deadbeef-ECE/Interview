public class Solution {
    // O(1) space, O(n) time
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if(slow.equals(fast))
                return true;
        }
        return false;
    }
}