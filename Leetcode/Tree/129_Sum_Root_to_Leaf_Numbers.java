public class Solution {
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public int sumNumbers(TreeNode root) {
        if(root == null)    return 0;
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int sum){
        if(root == null)    return 0;
        int cur = sum * 10 + root.val;
        if(root.left == null && root.right == null){
            return cur;
        }
        return sum(root.left, cur) + sum(root.right, cur);
    }
}