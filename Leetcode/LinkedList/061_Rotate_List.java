public class Solution {
    // 机智解法:
    // O(1) space, O(n) time
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        k = len - k % len;
        // construct a loop
        cur.next = head;
        while(k > 0){
            cur = cur.next;
            k--;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }

    // 2b解法
    // O(1) space, O(n) time
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        k = k % len;
        if(k == 0)  return head;
        ListNode slow = head, fast = head;
        while(k > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}