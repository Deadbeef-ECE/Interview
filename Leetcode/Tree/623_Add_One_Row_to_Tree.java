public class Solution {
    // Level order
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)    return root;
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(d == depth + 1){
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    TreeNode left = cur.left;
                    TreeNode right = cur.right;
                    newLeft.left = left;
                    newRight.right = right;
                    cur.left = newLeft;
                    cur.right = newRight;
                }
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            depth++;
            // save time
            if(depth == d)  break;
        }
        return root;
    }
}