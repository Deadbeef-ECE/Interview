class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
        if(root == null)    return 0;        
        int left = dfs(root.left);
        int right = dfs(root.right);
        int pathMax = Math.max(left, right) + 1;
        max = Math.max(max, left + right);
        return pathMax;
    }
}