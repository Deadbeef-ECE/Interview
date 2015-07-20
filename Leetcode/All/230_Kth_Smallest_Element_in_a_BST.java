public class Solution {
    // DFS + Prune:
    // O(1) space, O(logn + k) time
    // logn is the height of the BST, we need logn time to
    // reach the left most leaf, then O(k) to reach target
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0)  return 0;
        int[] ret = new int[1];
        int[] start = {0};
        helper(root, start, k, ret);
        return ret[0];
    }
    
    private void helper(TreeNode root, int[] start, int k, int[] ret){
        if(start[0] < k && root != null){
            helper(root.left, start, k, ret);
            start[0] += 1;
            if(start[0] == k)
                ret[0] = root.val;
            helper(root.right, start, k, ret);   
        }
    }
}