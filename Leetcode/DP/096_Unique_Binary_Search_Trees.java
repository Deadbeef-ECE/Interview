public class Solution {
    // 一维DP:
    // O(n) space, O(n^2) time
    public int numTrees(int n) {
        if(n < 0)   return 0;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        // outer loop i means total node in the tree
        for(int i = 2; i <= n; i++){
            // inner loop j means total nodes of left subtree
            // then i-j-1 means total nodes of right subtree
            // -1 since we need to reserve one node as root
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}