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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int last = 1;
        int num = 0;
        int depth = 1;
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            last--;
            if(cur.left != null){
                num++;
                queue.add(cur.left);
            }
            if(cur.right != null){
                num++;
                queue.add(cur.right);
            }
            if(last == 0 && num != 0){
                depth++; 
                last = num;
                num = 0;
            }
        }
        return depth;
    }
}