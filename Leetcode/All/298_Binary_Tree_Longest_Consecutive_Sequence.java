public class Solution {
    // Bottom-up
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null)    return 0;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null)    return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int lMax = (root.left!= null && root.left.val - root.val == 1) ? left + 1 : 1;
        int rMax = (root.right!= null && root.right.val - root.val == 1) ? right + 1 : 1;
        max = Math.max(max, Math.max(lMax, rMax));
        return Math.max(lMax, rMax);
    }

    // Top-down
    public int longestConsecutive(TreeNode root) {
        if(root == null)    return 0;
        return Math.max(helper(root.left, root.val, 1), helper(root.right, root.val, 1));
    }
    
    private int helper(TreeNode root, int pre, int len){
        if(root == null)    return len;
        
        if(root.val - pre == 1){
            int left = helper(root.left, root.val, len + 1);
            int right = helper(root.right, root.val, len + 1);
            return Math.max(left, right);
        }
        int left = helper(root.left, root.val, 1);
        int right = helper(root.right, root.val, 1);
        return Math.max(len, Math.max(left, right));
    }
}