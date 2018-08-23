public class Solution {
	// Recursion
	// O(height) space, O(nlogn) time
    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Iteration
    // O(n) space, O(n) time
    public TreeNode invertTree(TreeNode root) {
        if(root == null)    return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
        return root;
    }
}