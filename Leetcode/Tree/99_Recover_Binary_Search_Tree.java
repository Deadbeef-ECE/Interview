public class Solution {
    // DFS Recursion:
    TreeNode prev;
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        if(first != null & second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return;
    }
    
    private void inOrder(TreeNode root){
        if(root == null)    
            return;
        inOrder(root.left);
        
        if(prev != null && prev.val > root.val){
            if(first == null)   first = prev;
            second = root;
        }
        prev = root;
        
        inOrder(root.right);
    }

    //TODO iteration?
}