class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)   return 0;
        int[] max = {0};
        dfs(root.val, root, max);
        return max[0];
    }
    
    private int dfs(int parentValue, TreeNode root, int[] max){
        if(root == null)    return 0;
        int left = dfs(root.val, root.left, max);
        int right = dfs(root.val, root.right, max);
        left = root.left != null && root.val == root.left.val ? left + 1 : 0;
        right = root.right != null && root.val == root.right.val ? right + 1 : 0;
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right);
    }
}