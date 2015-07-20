public class Solution {
    TreeNode last;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode savedRight = root.right;
        if(last != null){
           last.left = null;
           last.right = root;
        }
        last = root;
        flatten(root.left);
        flatten(savedRight);
    }
}