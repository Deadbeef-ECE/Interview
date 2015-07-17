public class Solution {
    // Inorder Recursion solution:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)    return true;
        if(!isValidBST(root.left))  return false;
        if(prev != null){
            if(prev.val >= root.val)
                return false;
        }
        prev = root;
        if(!isValidBST(root.right)) return false;
        return true;
    }

    // Inorder Iteration solution:
    // O(logn) space
    // O(n) time
    public boolean isValidBST2(TreeNode root) {
        if(root == null)    return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode prev = null;
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode temp = stack.pop();
                if(temp.right != null){
                    root = temp.right;
                    stack.push(temp.right);
                }
                if(prev != null && prev.val >= temp.val)
                    return false;
                prev = temp;
            }
        }
        return true;
    }
}