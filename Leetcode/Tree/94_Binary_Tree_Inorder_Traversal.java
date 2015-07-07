public class Solution {
    // Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        inOrder(root, ret);
        return ret;
    }
    
    private void inOrder(TreeNode root, List<Integer> ret){
        if(root == null)    return;
        inOrder(root.left, ret);
        ret.add(root.val);
        inOrder(root.right, ret);
    }

    // Iteration:
    // O(logn) space, O(n) time
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode temp = stack.pop();
                if(temp.right != null){
                    stack.push(temp.right);
                    root = temp.right;
                }
                ret.add(temp.val);
            }
        }
        return ret;
    }
}