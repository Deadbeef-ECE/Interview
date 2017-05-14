public class Solution {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }
    
    public int postOrder(TreeNode root){
        if(root == null)    return 0;
        int l = postOrder(root.left);
        int r = postOrder(root.right);
        tilt += Math.abs(l - r);
        return l + r + root.val;
    }
}