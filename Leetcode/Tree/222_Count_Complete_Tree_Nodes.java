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
    // Recursion:
    // O(h) space, O(h^2) time (h = logn)
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftNum = leftHeight(root.left);
        int rightNum = rightHeight(root.right);
        if(leftNum == rightNum)
            return (2 << leftNum) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int leftHeight(TreeNode root){
        if(root == null)    return 0;
        return 1+leftHeight(root.left);
    }
    
    private int rightHeight(TreeNode root){
        if(root == null)    return 0;
        return 1+rightHeight(root.right);
    }

    // Iteration:
    // O(1) space, O(h^2)time (h = logn)

}