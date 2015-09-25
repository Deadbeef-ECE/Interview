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

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1)   return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode front = head.next;
        while(front != null){
            for(int i = 0; i < k - 2; i++){
                front = front.next;
                if(front == null)
                    return dummy.next;
            }
            ListNode temp = front.next;
            front.next = null;
            pre.next = reverse(cur);
            cur.next = temp;
            pre = cur;
            cur = temp;
            front = temp == null ? null : temp.next;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode node){
        if(node == null)    return null;
        if(node.next == null)   return node;
        ListNode newHd = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHd;
    }
}