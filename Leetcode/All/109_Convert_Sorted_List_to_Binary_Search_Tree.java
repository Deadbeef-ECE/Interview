public class Solution {
    // Brute-Force:
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        int num = 0;
        ListNode cur = head;
        while(cur != null){
            num++;
            cur = cur.next;
        }
        return BuildTree(head, num);
    }
    
    private TreeNode BuildTree(ListNode head, int end){
        if(end <= 0) return null;
        int mid = (1 + end)/2;
        int temp = mid - 1;
        ListNode cur = head;
        while(temp > 0){
            cur = cur.next;
            temp--;
        }
        TreeNode root = new TreeNode(cur.val);
        root.left = BuildTree(head, mid - 1);
        root.right = BuildTree(cur.next, end - mid);
        return root;
    }
    
    // O(n) solution:
    ListNode curNode = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        curNode = head;
        ListNode start = head;
        int num = 0;
        while(start != null){
            num++;
            start = start.next;
        }
        return buildBST(0, num - 1);
    }
    
    private TreeNode buildBST(int start, int end){
        if(start > end)    return null;
        int mid = start + (end - start)/2;
        TreeNode left = buildBST(start, mid - 1);
        TreeNode root = new TreeNode(curNode.val);
        root.left = left;
        curNode = curNode.next;
        root.right = buildBST(mid+1, end);
        return root;
    }
}