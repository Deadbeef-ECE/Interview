class Solution {
	// Recursion:
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)    return null;
        if(root.val < val)  return searchBST(root.right, val);
        if(root.val > val)  return searchBST(root.left, val);
        return root;
    }
    // Iteration:
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)    return null;
        TreeNode cur = root;
        
        while(cur != null){
            if(cur.val == val)
                break;
            if(cur.val < val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return cur;
    }
}