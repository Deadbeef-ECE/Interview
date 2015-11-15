public class Solution {
    // recursion:
    TreeNode last;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode savedRight = root.right;
        if(last != null){
           last.left = null;
           last.right = root;
        }
        last = root;
        flatten(root.left);
        flatten(savedRight);
    }

    // iteration:
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null){
            if(root.right != null){
                stack.push(root.right);
                root.right = null;
            }
            else if(root.left != null){
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
            else if(root.left == null && root.right == null){
                if(stack.isEmpty()) return;
                TreeNode temp = stack.pop();
                root.right = temp;
                root = temp;
            }
        }
        return;
    }
}