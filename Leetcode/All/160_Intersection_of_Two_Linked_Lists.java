public class Solution {
    // O(1) space, O(n) time
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;
        while(curA != null){
            curA = curA.next;
            lenA++;
        }
        while(curB != null){
            curB = curB.next;
            lenB++;
        }
        int diff = Math.abs(lenA - lenB);
        ListNode shortHead = lenA > lenB ? headB : headA;
        ListNode longHead = shortHead == headB ? headA : headB;
        while(diff > 0){
            diff--;
            longHead = longHead.next;
        }
        while(longHead != null){
            if(longHead == shortHead)
                return longHead;
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }
}