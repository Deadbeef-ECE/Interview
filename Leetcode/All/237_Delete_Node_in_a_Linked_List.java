public class Solution {
	// O(1) space, O(1) time
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}