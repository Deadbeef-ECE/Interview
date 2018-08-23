class Solution {
    // 其实就是找最小的完全二叉树
    TreeNode ret = null;
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)    return null;
        completeTree(root, 0);
        return ret;
    }
    
    private int completeTree(TreeNode root, int depth){
        if(root == null)    return depth;
        int left = completeTree(root.left, depth + 1);
        int right = completeTree(root.right, depth + 1);
        if(left == right && left >= maxDepth){
            ret = root;
            maxDepth = left;
            return left;
        }
        return Math.max(left, right);
    }
}