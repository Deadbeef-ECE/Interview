public class Solution {
    // Divide & Conquer:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(nlogn) time
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return merge(lists, 0, lists.length-1);
    }
    
    private ListNode merge(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = start + (end - start)/2;
        ListNode ret1 = merge(lists, start, mid);
        ListNode ret2 = merge(lists, mid+1, end);
        return mergeTwoList(ret1, ret2);
    }
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
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
}