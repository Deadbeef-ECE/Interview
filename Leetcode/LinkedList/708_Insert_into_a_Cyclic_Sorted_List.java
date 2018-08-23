/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null)    return new Node(insertVal, null);
        // only one node
        if (head.next == head) {
            head.next = new Node(insertVal, null);
            head.next.next = head;
            return head;
        }
        
        Node prev = head;
        Node curNode = head.next;
        
        // case 1: 1 -> 3 -> 5, insertVal = 2 (normal case)
        // case 2: 1 -> 3 -> 5, insertVal = 0 (edge case)
        // case 3: 1 -> 3 -> 5, insertVal = 6 (edge case)
        // case 4: 3 -> 3 -> 3, insertVal = 3 (edge case)
        while(!(prev.val <= insertVal && insertVal <= curNode.val ||
                prev.val >= curNode.val && insertVal <= curNode.val ||
                prev.val >= curNode.val && insertVal >= prev.val)){
            prev = curNode;
            curNode = curNode.next;
            if(curNode == head)    break;
        }
        prev.next = new Node(insertVal, curNode);
        return head;
    }
}