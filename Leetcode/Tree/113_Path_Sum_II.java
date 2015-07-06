public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null)    return ret;
        List<Integer> path = new LinkedList<Integer>();
        path.add(root.val);
        doDFS(root, sum-root.val, path, ret);
        return ret;
    }
    
    private void doDFS(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret){
        if(root.left == null && root.right == null && sum == 0){
            List<Integer> list = new LinkedList<Integer>(path);
            ret.add(list);
            return;
        }
        if(root.left != null){
            path.add(root.left.val);
            doDFS(root.left, sum - root.left.val, path, ret);
            path.remove(path.size()-1);
            
        }
        if(root.right != null){
            path.add(root.right.val);
            doDFS(root.right, sum - root.right.val, path, ret);
            path.remove(path.size()-1);
        }
    }
}