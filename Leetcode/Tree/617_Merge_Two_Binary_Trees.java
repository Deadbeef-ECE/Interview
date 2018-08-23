/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)  return null;
        if(t1 == null)  return t2;
        if(t2 == null)  return t1;
        
        int v = t1.val + t2.val;
        TreeNode newNode = new TreeNode(v);
        newNode.left = merge(t1.left, t2.left);
        newNode.right = merge(t1.right, t2.right);
        return newNode;
    }
}