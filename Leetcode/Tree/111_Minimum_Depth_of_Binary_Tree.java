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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int last = 1;
        int depth = 1;
        int num = 0;
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null)
                return depth;
            last--;
            if(cur.left != null){
                queue.add(cur.left);
                num++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                num++;
            }
            if(last == 0){
                last = num;
                num = 0;
                depth++;
            }
        }
        return depth;
    }
}