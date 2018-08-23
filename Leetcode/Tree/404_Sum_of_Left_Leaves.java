public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur.left != null && cur.left.left == null && cur.left.right == null)
                sum += cur.left.val;
            if(cur.left != null)    q.add(cur.left);
            if(cur.right != null)   q.add(cur.right);
        }
        return sum;
    }

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)    return 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }
        
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        
        return sum;
    }
}