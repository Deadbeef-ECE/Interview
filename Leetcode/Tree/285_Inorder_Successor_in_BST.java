class Solution {
    TreeNode pre = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)    return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            if(root != null && root.left != null){
                stack.push(root.left);
                root = root.left;
            }else{
                TreeNode cur = stack.pop();
                if(p.equals(pre))   return cur;
                pre = cur;
                if(cur.right != null){
                    stack.push(cur.right);
                    root = cur.right;
                }
            }
        }
        return null;
    }

    TreeNode pre = null;
    TreeNode cur = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)    return null;
        inorder(root, p);
        return cur;
    }
    
    private void inorder(TreeNode root, TreeNode p){
        if(root == null)    return;
        inorder(root.left, p);
        if(p.equals(pre)) cur = root;
        pre = root;
        inorder(root.right, p);
    }
}