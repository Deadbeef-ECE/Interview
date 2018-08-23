public class Solution {
    // DFS Recursion:
    // O(1) space OR O(logn) if consider recursion stack
    // O(n) time
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // BFS Iteration:
    // O(n) space, n is TreeNode number in the level which has minimum depth
    // O(n) time, n is TreeNode number before reaching the "highest" leaf
    public int minDepth2(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null)
                    return level;
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
            }
            if(!q.isEmpty())    level++;
        }
        return level;
    }
}