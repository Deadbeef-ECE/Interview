public class Solution {
    // Top-down:
    // O(nlogn) if balanced tree, or O(n^2) if linkedlist
    // O(1) space or O(n^2) space if consider recursion stack
    public int pathSum(TreeNode root, int sum) {
        if(root == null)    return 0;
        return dfs(root,sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int dfs(TreeNode root, int sum){
        if(root == null)    return 0;
        int cnt = 0;
        if(root.val == sum)  cnt++;
        return cnt + dfs(root.left, sum - root.val) + dfs(root.right, sum - root.val);
    }
}