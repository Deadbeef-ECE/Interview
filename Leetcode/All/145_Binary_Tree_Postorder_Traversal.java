public class Solution {
    // Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        postOrder(root, ret);
        return ret;
    }
    
    private void postOrder(TreeNode root, List<Integer> ret){
        if(root == null)    return;
        postOrder(root.left, ret);
        postOrder(root.right, ret);
        ret.add(root.val);
    }

    // Iteration(with precursor):
    // O(logn) space, O(n) time
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode temp = stack.peek();
                if(temp.right != null && temp.right != prev){
                    root = temp.right;
                    stack.push(temp.right);
                }else{
                    prev = stack.pop();
                    ret.add(temp.val);
                }
            }
        }
        return ret;
    }

    // 虽然答案正确, 但此方法会把树的结构玩坏, 不推荐
    // Iteration(without precursor):
    // O(logn) space, O(n) time
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode temp = stack.peek();
                if(temp.right == null){
                    ret.add(temp.val);
                    stack.pop();
                }else{
                    root = temp.right;
                    temp.right = null;
                    stack.push(root);
                }
            }
        }
        return ret;
    }
}