public class Solution {
   public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode node = root, parent = null, right = null;  
        
        while (node != null) {  
            TreeNode left = node.left;  
            node.left = right;  
            right = node.right;  
            node.right = parent;  
            parent = node;  
            node = left;  
        }  
        return parent;  
    }
}