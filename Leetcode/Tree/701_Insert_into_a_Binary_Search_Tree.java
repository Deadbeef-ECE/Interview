class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)    return root;
        TreeNode cur = root;
        TreeNode p = null;
        while(cur != null){
            TreeNode tmp = cur;
            if(cur.val > val)   cur = cur.left;
            else if(cur.val < val)  cur = cur.right;
            p = tmp;
        }
        if(p.val < val){
            p.right = new TreeNode(val);
        }else{
            p.left = new TreeNode(val);
        }
        return root;
    }
}