/* 题意:
 * 给一个BT, 数下有多少个Uni-value subtree(所有node的value相同)
 * E.g.       5
 *           / \
 *          1   5
 *         / \   \
 *        5   5   5
 * return 4
 *
 * Solution:
 * bottom-up recursion, 每个叶子都是一个uni-value subtree. 在recursion但返回的时候
 * 判断当前node和parent的val是否相同
 */

public class Solution {
    // O(logn) space, O(n) time
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)    return 0;
        int[] ret = {0};
        count(root.val, root, ret);
        return ret[0];
    }
    
    private boolean count(int val, TreeNode root, int[] ret){
        if(root == null)    return true;
        boolean l = count(root.val, root.left, ret);
        boolean r = count(root.val, root.right, ret);
        if(l && r)
            ret[0]++;
        return l && r && root.val == val;
    }
}