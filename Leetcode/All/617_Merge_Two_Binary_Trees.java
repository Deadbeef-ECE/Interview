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
    
    public TreeNode merge(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)    return null;
        int val = t1 == null ? 0 : t1.val;
        val += t2 == null ? 0 : t2.val;
        TreeNode t1_left = t1 == null ? null : t1.left, t1_right = t1 == null ? null : t1.right;
        TreeNode t2_left = t2 == null ? null : t2.left, t2_right = t2 == null ? null : t2.right;
        TreeNode curNode = new TreeNode(val);
        curNode.left = merge(t1_left, t2_left);
        curNode.right = merge(t1_right, t2_right);
        return curNode;
    }
}