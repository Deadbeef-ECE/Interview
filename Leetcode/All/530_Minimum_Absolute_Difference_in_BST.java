public class Solution {
    // Recursion
    // O(n) time, O(1) space or O(h) space.
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        int[] diff = {Integer.MAX_VALUE};
        dfs(root, diff);
        return diff[0];
    }
    
    public void dfs(TreeNode root, int[] diff){
        if(root == null)    return;
        dfs(root.left, diff);
        if(pre != null){
            int d = Math.abs(root.val - pre.val);
            diff[0] = Math.min(diff[0], d);
        }
        pre = root;
        dfs(root.right, diff);
    }
    // Iteration:
    // O(n) time, O(h) space
    public int getMinimumDifference(TreeNode root) {
        TreeNode pre = null;
        int diff = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode tmp = stack.pop();
                if(pre != null)
                    diff = Math.min(diff, Math.abs(pre.val - tmp.val));
                pre = tmp;
                if(tmp.right != null){
                    stack.push(tmp.right);
                    root = tmp.right;
                }
            }
        }
        return diff;
    }
}