public class Solution {
    // Postorder traversal
    // O(n) time, O(h) space for recursion stack
    // [0 or 1 -> true or false,0 -> max at cur_root,0->min,0->max]
    // https://www.youtube.com/watch?v=4fiDs7CCxkc
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)    return 0;
        int[] ret = helper(root);
        return ret[1];
    }
    
    public int[] helper(TreeNode root){
        int[] ret = {0,0,0,0};
        if(root == null){
            ret[0] = 1;
            return ret;
        }
        if(root.left == null && root.right == null){
            ret[0] = ret[1] = 1;
            ret[2] = ret[3] = root.val;
            return ret;
        }
        int[] l = helper(root.left);
        int[] r = helper(root.right);
        // left is BST and right is BST and root fits
        if(l[0] == 1 && r[0] == 1){
            ret[0] = 1; ret[1] = l[1] + r[1] + 1;
            if(root.left == null && root.val < r[2]){
                ret[2] = root.val; ret[3] = r[3];
                return ret;
            }
            // no right child, and root.val > left.child.max 
            if(root.right == null && root.val > l[3]){
                ret[2] = l[2]; ret[3] = root.val;
                return ret;
            }
            if(root.val > l[3] && root.val < r[2]){
                ret[2] = l[2];  ret[3] = r[3];
                return ret;
            }
        }
        // not a BST, bubble up the child info
        ret[0] = 0; ret[1] = Math.max(l[1], r[1]);
        return ret;
    }
}