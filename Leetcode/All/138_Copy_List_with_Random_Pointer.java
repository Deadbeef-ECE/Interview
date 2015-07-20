public class Solution {
    // O(1) space, O(n) time
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)    return head;
        RandomListNode cur = head;
        // copy direct list node
        while(cur != null){
            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        // copy random list node
        cur = head;
        while(cur != null){
            RandomListNode temp = cur.random;
            if(temp != null)
                cur.next.random = temp.next;
            cur = cur.next.next;
        }
        // split
        cur = head;
        RandomListNode dupHead = head.next;
        while(cur != null){
            RandomListNode temp = cur.next.next;
            RandomListNode copy = cur.next;
            copy.next = temp == null ? null : temp.next;
            cur.next = temp;
            cur = temp;
        }
        return dupHead;
    }
}