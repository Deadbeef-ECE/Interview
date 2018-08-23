public class Solution {
    // Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(nlogn) time
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd)   return null;
        
        int rootIdx;
        for(rootIdx = inStart; rootIdx <= inEnd; rootIdx++){
            if(inorder[rootIdx] == preorder[preStart])
                break;
        }
        int len = rootIdx - inStart;
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart+1, preStart+len, inorder, inStart, rootIdx-1);
        root.right = buildTree(preorder, preStart+len+1, preEnd, inorder, rootIdx+1, inEnd);
        return root;
    }


}