public class Solution {
    // Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(nlogn) time
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        return buildTree(inorder, 0, inLen-1, postorder, 0, postLen-1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd) return null;
        int rootIdx;
        for(rootIdx = inStart; rootIdx <= inEnd; rootIdx++){
            if(inorder[rootIdx] == postorder[postEnd])
                break;
        }
        int len = rootIdx - inStart;
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTree(inorder, inStart, rootIdx-1, postorder, postStart, postStart+len-1);
        root.right = buildTree(inorder, rootIdx+1, inEnd, postorder, postStart+len, postEnd-1);
        return root;
    }
}