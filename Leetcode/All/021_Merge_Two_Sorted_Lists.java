public class Solution {
    // O(1) space, O(n) time
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    // 简洁版本:
    public ListNode mergeTwoLists2(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l != null && r != null){
            cur.next = l.val < r.val ? l : r;
            l = cur.next == l ? l.next : l;
            r = cur.next == r ? r.next : r;
            cur = cur.next;
        }
        cur.next = l == null ? r : l;
        return dummy.next;
    }
}