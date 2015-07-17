public class Solution {
    // 二维DP, O(m*n) space, O(m*n) time
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 最左一列
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        // 最上一排
        for(int j = 0; j < n; j++)
            dp[0][j] = 1;
        // 其它格子
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // 二维DP空间压缩, O(n) space, O(m*n) time
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}