public class Solution {
    // Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        preOrder(root, ret);
        return ret;
    }
    
    private void preOrder(TreeNode root, List<Integer> ret){
        if(root == null)    return;
        ret.add(root.val);
        preOrder(root.left, ret);
        preOrder(root.right, ret);
    }

    // Iteration:
    // O(logn) space, O(n) time
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    
            return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            ret.add(temp.val);
            if(temp.right != null)  
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        
        return ret;
    }
}