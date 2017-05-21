public class Solution {
    // 通俗易懂版本：
    TreeNode pre = null;
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)    return root;
        dfs(root);
        return root;
    }
    
    public void dfs(TreeNode root){
        if(root == null)    return;
        dfs(root.right);
        int curValue = root.val;
        if(pre != null){
            root.val += preSum;
        }
        pre = root;
        preSum += curValue;
        dfs(root.left);
    }
    // 简洁版: 
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    
    public void dfs(TreeNode root){
        if(root == null)    return;
        dfs(root.right);
        root.val += preSum;
        preSum = root.val;
        dfs(root.left);
    }
}