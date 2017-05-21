public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if(root == null)    return ret;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int last = 1, num = 0;
        int max = Integer.MIN_VALUE;
        
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            max = Math.max(max, cur.val);
            last--;
            if(cur.left != null){
                q.add(cur.left);
                num++;
            }
            if(cur.right != null){
                q.add(cur.right);
                num++;
            }
            if(last == 0){
                last = num;
                num = 0;
                ret.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return ret;
    }
}