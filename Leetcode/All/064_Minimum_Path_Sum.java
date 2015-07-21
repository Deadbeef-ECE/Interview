public class Solution {
    // 二维DP
    // O(m*n) space, O(m*n) time
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < row; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
            
        for(int j = 1; j < col; j++)
            dp[0][j] = dp[0][j-1] + grid[0][j];
            
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    // 二维DP空间压缩
    // O(n) space, O(m*n) time
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < row; i++){
            dp[0] = dp[0] + grid[i][0];
            for(int j = 1; j < col; j++){
                dp[j] = Math.min(dp[j-1],dp[j]) + grid[i][j];
            }
        }
        return dp[col-1];
    }
}