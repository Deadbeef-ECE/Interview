// http://bookshadow.com/weblog/2015/07/10/leetcode-linked-list-cycle-ii/
public class Solution {
    // O(1) space, O(n) time
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if(slow.equals(fast))
                break;
        }
        if(fast == null)
            return null;
        slow = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}