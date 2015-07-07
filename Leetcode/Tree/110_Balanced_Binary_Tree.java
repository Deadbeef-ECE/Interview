public class Solution {
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public boolean isBalanced(TreeNode root) {
        if(check(root) == -1)
            return false;
        return true;
    }
    
    private int check(TreeNode root){
        if(root == null)    
            return 0;
        int leftHeight = check(root.left);
        if(leftHeight == -1)    
            return -1;
        int rightHeight = check(root.right);
        if(rightHeight == -1)   
            return -1;
        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1)    
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}