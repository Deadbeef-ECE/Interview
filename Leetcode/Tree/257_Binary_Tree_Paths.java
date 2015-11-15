public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new LinkedList<String>();
        rec(root, "", ret);
        return ret;
    }
    
    private void rec(TreeNode root, String path, List<String> ret){
        if(root == null)    return;
        if(root.left == null && root.right == null){
            path += String.valueOf(root.val);
            ret.add(path);
            return;
        }
        path += String.valueOf(root.val) + "->";
        rec(root.left, path, ret);
        rec(root.right, path, ret);
    }
}