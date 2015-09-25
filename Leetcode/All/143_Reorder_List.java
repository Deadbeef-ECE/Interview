public class Solution {
    // O(1) space, O(n) time
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null || fast.next == null)   break;
            fast = fast.next;
            slow = slow.next;
        }
        ListNode hd1 = head;
        ListNode hd2 = slow.next;
        slow.next = null;
        // reverse the second list
        ListNode cur = hd2;
        ListNode next = cur.next;
        cur.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        hd2 = cur;
        // reorder
        ListNode p = hd1;
        ListNode q = hd2;
        while(q != null){
            ListNode tmp1 = p.next;
            ListNode tmp2 = q.next;
            p.next = q;
            q.next = tmp1;
            p = tmp1;
            q = tmp2;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)   
            return;
        // first part >= second part
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            if(fast.next.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        
        // reverse second part;
        slow.next = null;
        ListNode pre = slow;
        ListNode cur = second;
        ListNode front = second.next;
        while(cur != null){
            cur.next = pre.next;
            pre.next = cur;
            cur = front;
            front = front == null ? null : front.next;
        }
        // cut between two parts
        second = slow.next;
        slow.next = null;

        ListNode p1 = first, p2 = second;
        while(p2 != null){
            ListNode temp = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = temp;
        }
        return;
    }
}