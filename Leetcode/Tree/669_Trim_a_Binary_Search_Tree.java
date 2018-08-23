class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)    return null;
        if(root.val < L)    return trimBST(root.right, L, R);
        if(root.val > R)    return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)    return null;
        while(root.val < L || root.val > R){
            root = root.val < L ? root.right : root.left;
        }
        
        TreeNode cur = root;
        while(cur != null){
            while(cur.left != null && cur.left.val < L){
                cur.left = cur.left.right;
            }
            cur = cur.left;
        }
        cur = root;
        while(cur != null){
            while(cur.right != null && cur.right.val > R){
                cur.right = cur.right.left;
            }
            cur = cur.right;
        }
        return root;
    }
}