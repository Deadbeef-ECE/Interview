public class Solution {
    public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                max = Math.max(max, cur.val);
                if(cur.left != null)    q.add(cur.left);
                if(cur.right != null)   q.add(cur.right);
            }
            ret.add(max);
        }
        return ret;
    }
}