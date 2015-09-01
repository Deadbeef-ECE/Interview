/* 题意:
 * 给一个BST和一个double target, 找到和target最接近的点
 *
 * Solution:
 * recursion + iteration
 */

 public class Solution {
    // Recursion:
    // O(logn) space, O(logn) time 
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        double[] diff = {Double.POSITIVE_INFINITY};
        int[] ret = {Integer.MAX_VALUE};
        helper(root, target, diff, ret);
        return ret[0];
    }
    
    private void helper(TreeNode root, double target, double[] diff, int[] ret){
        if(root == null || diff[0] == 0.0)    return;
        if(Math.abs(root.val - target) < diff[0]){
            diff[0] = Math.abs((double)root.val - target);
            ret[0] = root.val;
        }
        if(target < root.val)
            helper(root.left, target, diff, ret);
        if(target > root.val)
            helpxer(root.right, target, diff, ret);
    }

    // Iteration:
    // O(1) space, O(logn) time 
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        TreeNode cur = root;
        int ret = root.val;
        double diff = Double.POSITIVE_INFINITY;
        while(cur != null){
            if(Math.abs((double)cur.val - target) < diff){
                diff = Math.abs((double)cur.val - target);
                ret = cur.val;
            }
            if(cur.val == target)  break;
            if(target < cur.val)   cur = cur.left;
            else if(target > cur.val)   cur = cur.right;
        }
        return ret;
    }
}