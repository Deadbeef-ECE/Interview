public class Solution {
    // Bottom-Up Solution:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   
            return root;
        return left != null ? left : right;
    }

    // Top-Down Solution:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(logn) time
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }

    // Iteration:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // assume p is always smaller than q
        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        
        TreeNode lca = root;
        while(!(p.val <= lca.val && q.val >= lca.val)){
            if(p.val > lca.val)
                lca = lca.right;
            else if(q.val < lca.val)
                lca = lca.left;
        }
        return lca;
    }
}