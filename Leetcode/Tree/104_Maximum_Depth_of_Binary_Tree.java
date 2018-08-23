public class Solution {
    // DFS Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public int maxDepth(TreeNode root) {
        if(root == null)    return 0;
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    // BFS Iteration:
    // O(n) space, n is leaf number
    // O(n) time, n is TreeNode number in totoal
    public int maxDepth2(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int num = 0;
            while(size-- > 0){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                    num++;
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                    num++;
                }
            }
            if(num != 0)    level++;
        }
        return level;
    }
}