public class Solution {
    // recursion: Inoder
    int max = 1;
    int val;
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)    return 0;
        val = root.val;
        dfs(root, 1);
        return val;
    }
    
    public void dfs(TreeNode root, int depth){
        if(root == null)    return;
        dfs(root.left, depth + 1);
        if(max < depth){
            val = root.val;
            max = depth;
        }
        dfs(root.right, depth + 1);
    }
    // Iteration: BFS left->right
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int val = root.val;
        int last = 1, num = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
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
                val = q.isEmpty() ? val : q.peek().val;
            }
        }
        return val;
    }
    // Interation: BFS right->left
    public int findBottomLeftValue(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int val = root.val;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            val = cur.val;
            if(cur.right != null)
                q.add(cur.right);
            if(cur.left != null)
                q.add(cur.left);
        }
        return val;
    }
}